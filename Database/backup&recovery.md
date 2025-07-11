## Backup & Recovery

### Step 1: Preparation - Unlock SYSBACKUP 

Before data is lost, schedule regular backups and store backups in a safe location (disk, external storage, cloud).
- **Full backup**: Saves entire DB
- **Incremental backup**: Saves only changes sine the last backup
- **Archived Redo Logs Backup**: Saves all transaction logs (all updates/changes between backups)

        rman target sysbackup/1
        BACKUP DATABASE PLUS ARCHIVELOG;
        ALTER SYSTEM SET db_recovery_file_dest_size = 10G;
        ALTER SYSTEM SET db_recovery_file_dest = 'C:\app\Oracle\fast_recovery_area';

### Data Loss
When there is data loss, for example, the database crashes, data is corrupted, or files are accidentally deleted, you will need to restore your data from the backup you've previously made. 

#### 1. Restore the datafiles, control files, and SPFILE, as needed

- **Cold/Offline Restore (Full)**: Database is shutdown, manual file copy
- **Hot/Online Restore (Incremental)**: Database may be active (but normally mounted or *nomount during restore*), use RMAN to restore from backup

##### Connect as SYSDBA 

    sqlplus / as sysdba 
    SHUTDOWN IMMEDIATE; 
    EXIT;

##### Start RMAN session

    rman target sysbackup/1

**Note**: Unless you have a user named sysbackup with a password 1, you will need to use *sys/password@databasename* or *rman targer /*

##### Restore

    STARTUP NOMOUNT; #Start instance without mounting
    RESTORE CONTROLFILE FROM 'backup_location'; #Restore control file
    ALTER DATABASE MOUNT; #Mount the database
    RESTORE DATABASE; #Restore the database

#### 2. Apply Archived Redo Logs (Recovery)

For transactions that took place ***after the backup***

- **Complete Recovery**: All redo logs are available
- **Incomplete Recovery / Point-In-Time Recovery (PITR)**: Some redo logs are missing or you choose to stop at a certain point

##### Recover the database (apply archived redo logs)

    RECOVER DATABASE;

#### 3. Open the database 

- If incomplete recovery: use RESETLOGS

        ALTER DATABASE OPEN RESETLOGS;

- If complete recovery: open normally 
  
        ALTER DATABASE OPEN;