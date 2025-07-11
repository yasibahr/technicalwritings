## Git Commands

1. **Git --version**: Check Git version and if it's been downloaded
2. **Git init**: 
3. **Git add**: Moves changes from working directory to staging area 
4. **Git branch**: Tells you which branch you're on
5. **Git checkout -b branch1**: Switch to branch1
6. **Git clone** 
7. **Git fetch**: Get all branches
8. **Git branch -d <branch1>**: Delete a branch 
9.  **Git commit**: Commit changes
10. **Git commit -m "Initial commit"***: Commit changes with a message 
11. **Git merge -abort**: Abort merge
12. **Git fetch -all**: Fetch all remote branches 
13. **Git pull origin master**: Fetch the changes from GitHub and merge them into your local master branch
14. **Git branch -a**: View all branches, including both local and remote
15. **Git pull**: If the remote branch gets updated, use this to pull latest changes while you are checked out on that branch

### How to Pull a Branch with Unsaved Changes (Stage Local Changes)
1. git add .
2. git stash push -m "stash changes"
3. git pull origin branchYouWantToPull

### How to Merge a Branch Into Master 
**1. Preparations**

Before merging, make sure your local repo is up-to-date with the remote repo.

        git checkout branch1
        git pull origin branch1
        git checkout master
        git pull origin master 

These commands switch to each branch and pull latest changes from the remote repo (origin) and merge them into your local master branch.

**2. Merge** 

Now that the local branches are up-to-date, you can merge your branch1 into master.

        git checkout master
        git merge branch1 

If there are no conflicts, merge may be automatically committed. If there are conflicts, Git will ask you to resolve them before completing the merge.

**3. Conflicts**

If there are merge conflicts, go into the files marked with conflicts, look for the conflict markers (<<<<<<<, =======, >>>>>>>) and resolve the changes. After editing the files, you need to add them to staging and then commit.

        git add .
        git commit -m "Resolved merge conflicts" 

**4. Push Changes**

After the merge is successful and all conflicts have been resolved, you can push your changes to the remote repo to ensure it's updated. 
        
        git push origin master

#### Tips & Good-To-Know
- Create a backup of your branch before merging, in case you need to rever to the pre-merge state
- Regularly merge changes into your main/master branch, can help reduce complexity of merges and potentional for conflicts 
- Your branch on VSC is your local branch
- Your branch on GitHub is your remote branch (origin)