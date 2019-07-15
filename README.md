# dbGit
Database version control for developers!

![dbGit Logo](https://github.com/mohamedanees6/dbGit/raw/master/src/main/resources/dbGit.png)

## What it does?
It is designed based on git VCS, but for Postgres Databases.

Alike Git, which saves the snapshot of the file changed, this saves the snapshot of database(To be optimized, save yourselves a lot of disk space for now please!) whenever you branch.

## Prerequisites

- Java 7 or above, install with Homebrew by following

`brew tap caskroom/versions`

`brew cask install java8`

- Postgres (Tested in version v9.3)

- DB server,can be started with `pg_ctl start` after installation of Postgres.

- Also, `pg_dump` and `psql` must be available on the `PATH` of the current terminal tab.

## How to Start?
Go to the required directory and type in 
- `mkdir dbgit`, creates a directory for dbgit. All the version control related data are saved in this folder.
- `brew install wget`, Installs wget using Homebrew.
- `wget https://github.com/mohamedanees6/dbGit/raw/master/src/main/dbGit.jar`, Downloads dbGit.jar from Github! to current repository
-  Paste the following line to your `~/.bash_profile`.
`alias dbgit="java -jar dbGit.jar"`

To verify this,type in dbgit and you must get the help content.

## Usage

### Init (Same as creating a branch in git)
This creates branch(snapshot) of a particular database. 
```
dbgit init <address:port> <db_name> <db_user_name> <db_password> <branch_name>
```
Example: `dbgit init localhost:5432 mytestdb postgres mypass123 mybranch1`

If there is no password, the same command reads as `dbgit init localhost:5432 mydb postgres null mybranch1`

Here `mybranch1` is the name of the branch created from the database `mydb`.


### Checkout (Same as git checkout branchName)
This check out the database data to the branch(snapshot) as described by the branch name of the database.
```
dbgit checkout <address:port> <db_name> <db_user_name> <db_password> <branch_name>
```
Example: `dbgit checkout localhost:5432 mytestdb postgres mypass123 mybranch`

### Drop (Same as deleting branch in git)

Drop available branch to a database
```
dbgit drop <address:port> <db_name> <db_user_name> <db_password> <branch_name>
```

Example : `dbgit drop localhost:5432 mytestdb postgres mypass123 mybranch`

## View (Same as viewing all the available branches in git)

View all available branches to a database
``` 
dbgit view <address:port> <db_name> <db_user_name> <db_password>
 ```
Example: `dbgit view localhost:5432 mytestdb postgres mypass123`

### Help 
Type in `dbgit help` to display the Help content.

## Get In Touch!
This is initial commit of an idea(After so much frustation of non-availability of version control!) and I welcome suggestions, please drop mail at mailto:mohamedanees6@gmail.com.

## Disclaimer
Please have a backup of the database handy in some secure folder. This is entitled **only for development in local machine** and **not for production use.**

****
தமிழனின் படைப்பு, ಕರ್ನಾಟಕದಿಂದ! 💙💙
