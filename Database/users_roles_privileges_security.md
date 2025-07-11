## Users, Roles, Privileges and Security 
System Privileges and Users
SYSDBA (System privilege)
•	Type: System privilege 
•	Description: Highest-level admin privilege privilege. Bypasses all security checks, owns data dictionary 
•	Use: full startup/shutdown, recovery, data dictionary maintenance 

	sqlplus / as sysdba

SYSBACKUP (System privilege)
-	Type: System privilege 
-	Description: Restricted admin privilege for backup/recovery 
-	Use: perform RMAN backups/restores without full SYSDBA rights 

	sqlplus sysbackup/1 as sysbackup //result: yB SYSBACKUP@orcl8276) >

SYS (User account)
-	Type: User account
-	Description: Owner of Oracle data dictionary (core metadata). Schema name = SYS.
-	Use: only used for SYSDBA sessions, never for day-to-day operations 

SYSTEM (User account) 
•	Type: User account 
•	Description: Administrative schema for creating internal tables, views, and most built-in Oracle tools 
•	Use: general DBA tasks (creating users, granting roles) 

•	Switch to the SYSTEM user (login to SYSTEM from SQL*Plus)
	sqlplus SYSTEM/password(L6!) //result: yB SYS@orcl8276) >

•	Or you can login to SYSTEM straight from the cmd prompt
	sqlplus system/password //result: yB SYS@orcl8276) >

2.	Get out of SQL mode
	Exit; 

Users, Roles and Privileges
Create User
	CREATE USER username IDENTIFIED BY password;
	ALTER USER username QUOTA UNLIMITED ON USERS;

Create Role
	CREATE ROLE role_name;


Grant Privileges on user and role
	GRANT CONNECT, RESOURCE TO username;
	GRANT SELECT, INSERT ON tablename TO role_name;

Grant role to user
	GRANT role_name TO username;


Backup and Restore
Step 1: Preparation – Unlock SYSBACKUP 
•	Login as SYSDBA
	sqlplus / as sysdba

•	Unlock SYSBACKUP: It might be locked by default for security so unlock it
	ALTER USER SYSBACKUP ACCOUNT UNLOCK;

•	Set Password: Set password for SYSBACKUP user to 1
	ALTER USER SYSBACKUP IDENTIFIED BY 1;

•	Show settings: Show the settings of all recovery parameters (do this with SYSTEM)
	Exit;
	sqlplus / as sysdba
	CONNECT SYTEM;
	SHOW PARAMETER RECOVERY;

Step 2: Configure the Fast Recovery Area (FRA) 
-	FRA is a single, managed directory (plus size quota) for all recovery-related files (backups, archive logs, flashback logs). 

•	Allocate FRA space: Set FRA space to 10GB maximum, so Oracle won’t exhaust disk space
	ALTER SYSTEM SET db_recovery_file_dest_size = 10G;

•	Set FRA location: Tells Oracle where to store backups, archived logs, flashback files, etc 
	ALTER SYSTEM SET db_recovery_file_dest = 'C:\app\YasamanBahramifarid\fast_recovery_area';

•	Verify FRA settings: Confirms Oracle accepted your size and path
	SHOW PARAMETER recovery;

Step 3: Confirm ARCHIVELOG Mode
-	ARCHIVELOG Mode is a Database setting that saves every filled redo log as an “archive” before reuse 
-	Enables PITR so you can replay transactions up to any moment 
-	Allows you to do hot backups, not just cold ones 
-	Prevents data loss 

•	Check archivelog mode before doing recoverable backups 
	ARCHIVE LOG LIST; 

Step 4: Prepare Database for Backup (RMAN) – Shutdown and Mount Database 
-	RMAN (Recovery Manger) is Oracle’s built-in backup/recovery engine with catalog and scripting
-	It automates backup creation, validation, cataloging, restores, and recovery 

•	Launch RMAN
	rman target sysbackup/1

Step 5 Option 1: Cold/Offline Backup
•	Clean shutdown: Ensures no active transactions; safe starting point
	SHUTDOWN IMMEDIATE;

•	**Copy all datafiles, control files, redo logs to backup location. Then Start database again

•	To enable ARCHVIELOG mode, the database must be in MOUNT mode 
	STARTUP MOUNT;

•	Create an initial backup (before changing to ARCHIVELOG) in NOARCHIVELOG mode
	BACKUP DATABASE;

•	Verify and Cleanup: To manage disk space, we delete old backups before creating new ones (list backups, delete those backups, make sure they’ve been deleted) – done for demonstration/learning purposes 
	LIST BACKUP;
	DELETE BACKUP;
	LIST BACKUP;

•	Enable ARCHIVELOG Mode: After Cold Backup; ARCHIVELOG mode is required for incremental backups and PITR.
	ALTER DATABASE ARCHIVELOG;

•	Open the database
	ALTER DATABASE OPEN;

•	Confirm ARCHIVELOG enabled
	sqlplus / as sysdba
	ARCHIVE LOG LIST;
	Exit;

Step 5 Option 2: Hot/Online Backup and ARCHIVELOG mode 
-	This is a critical full backup that includes data and archive logs, allowing for a full recovery.

•	Execute backup command in RMAN
	rman target sysbackup/1
	BACKUP DATABASE PLUS ARCHIVELOG;

•	List backup information: this gives a high-level summary of all backups, verifying that backups exist before restoring or recovering the database 
	LIST BACKUP SUMMARY;
	VALIDATE BACKUPSET ALL;

•	View RMAN config and check RMAN settings 
	SHOW ALL; 

•	Configure and Verify Default Backup Device: By default, RMAN stores backups on disk, but this setting ensures that backups are always saved to disk unless specified otherwise. If it's already set to disk, this step just confirms it.

•	Set default device to disk: do this if not already set; ensures disk backups
	CONFIGURE DEFAULT DEVICE TYPE TO DISK;
	CONFIGURE RETENTION POLICY TO REDUNDANCY 2;
	SHOW ALL;

•	Verify backup metadata 
	SHOW DEFAULT DEVICE TYPE; 
	EXIT; 

•	List Backup Summary
	LIST BACKUP SUMMARY; 

•	List Backup of a Specific Datafile 
	LIST BACKUP OF DATAFILE <datafile_ID>;

•	Validate a Specific Datafile Backup 
	VALIDATE DATAFILE <datafile_ID>;
 
•	Validate Restoration of an Entire Tablespace: No real restore is performed here, it just confirms it could before restored 
	RESTORE TABLESPACE <tablespace_name> VALIDATE;
 
Step 6: Simulate Disaster and Restore 
-	To test disaster recovery, we delete all database files and attempt to recover.

•	Shutdown the database and exit RMAN
	SHUTDOWN IMMEDIATE;
	EXIT;

•	**Move/delete all datafiles/control files/redo logs (to simulate data loss) 

•	Attempt to start the Database: expecting a fail here, since we deleted the physical database files/control files; this confirms the database is actually lost and needs recovery
	sqlplus / as sysdba 
	STARTUP;
	Exit; 

Step 7: Restore control file
-	Restore the control file from the backup. 
-	The control file stores metadata about the database (datafiles, redo logs, etc). Without a control file, Oracle doesn’t know which datafiles exist or where they are located. This step recreates the control file from your backup.
-	Start instance without control file and attempt to restore the control file
-	Without a control file, the database cannot be fully mounted or opened 

•	Launch RMAN 
	rman target sysbackup/1

•	Start instance in NOMOUNT mode: required to restore control file (there is none yet, we “deleted” it) 
	STARTUP NOMOUNT; 

•	Restore control file: from backup location 
	RESTORE CONTROLFILE FROM 'D:\ORACLE19CINSTALL\DATABASE\C-3002098481-20220502-00\backupfile.bkp';

•	Mount the database: required to access the file structure and proceed with data resource 
	ALTER DATABASE MOUNT; 

•	Restore all datafiles: Restore all datafiles from the backup back to disk/original location. RMAN pulls the latest backup and restores all tablespaces and user data.
	RESTORE DATABASE;

•	Recover database: Apply the redo logs to make sure all transactions are restored. A database backup only captures data up to the last backup. Redo logs replay all transactions that happened after the last backup, ensuring no committed data is lost.
	RECOVER DATABASE; 

•	Open database with RESETLOGS: RESETLOGS is needed because the control file was restored from backup, and redo logs were applied. This resets the log sequence and makes the database fully functional again. RESETLOGS used for incomplete recovery.
	ALTER DATABASE OPEN RESETLOGS; 

Step 8: Verify Recovery 
•	Check database name and open mode: confirms database is open 
	SELECT name, open_mode FROM V$DATABASE;

•	Check tablespaces: ensure all tablespaces are online 
	SELECT tablespace_name FROM DBA_TABLESPACES;

