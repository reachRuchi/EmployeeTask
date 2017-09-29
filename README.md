# EmployeeTask
A new Spring boot angular-4 hibernate JPA Mysql Workbench STS project 
git commands used that I would like to document for myself for pushing a git local repo to remote repo

1. create a local repo in the current working directory that you would like to upload to the remote github.com

2. create a repo in the remote github.com

3. open git bash

4. then inorder to change the username and user email to the one that is yours write the following commang in your local git bash
   git config --global user.name yourUserName
   git config --global user.email you@email.com

5. When you've done that, you need to register that new repo with a remote (where you'll upload -- push -- your files to), which in this case will be github. You'll get the correct URL from your repo on GitHub.

    $ git remote add origin https://github.com/[username]/[reponame].git

6. You need to add you existing files to your local commit:

    git add .   # this adds all the files

7. Then you need to make an initial commit, so you do:

   git commit -a -m "Initial commit" # this stages your files locally for commit. 
                                     # they haven't actually been pushed yet
    Now you've created a commit in your local repo, but not in the remote one. To put it on the remote, you do the second line you posted:

8. git push -u origin --all
