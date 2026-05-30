# GitCraft

GitCraft is a secure in-game Git command interface for Minecraft Paper servers. It lets server admins and developers manage Git repositories directly from Minecraft using `/git` commands.

Built and tested for Paper `1.21.11`.

> GitCraft may work on other `1.21.x` versions, but those versions have not been tested.

## Features

- Run Git commands in-game or from console
- Initialize repositories
- Add, commit, status, reset, fetch, pull, and push changes
- Manage the `origin` remote
- Store Git credentials using an encrypted local H2 database
- Support GitHub personal access tokens
- Permission-based command access
- Async Git operations to help avoid server lag

## Commands

```text
/git help
/git init --path=<folder>
/git remote --add --url=<repo-url> --path=<folder>
/git remote --set-url --url=<repo-url> --path=<folder>
/git remote --remove --path=<folder>
/git add . --path=<folder>
/git add <file> --path=<folder>
/git commit -m=<message> --path=<folder>
/git status --path=<folder>
/git reset --path=<folder>
/git reset --hard --path=<folder>
/git fetch --path=<folder>
/git pull --path=<folder>
/git push --path=<folder>
/git login --username=<username> --token=<token>
/git whoami
/git logout
```

## Basic Usage

1. Put `Git-Craft.jar` in your server's `plugins` folder.
2. Restart the server.
3. Run `/git help`.
4. Initialize a repository:

```text
/git init --path=plugins/MyProject
```

5. Add a remote:

```text
/git remote --add --url=https://github.com/user/repo.git --path=plugins/MyProject
```

6. Log in with a GitHub token:

```text
/git login --username=YourUsername --token=YourToken
```

7. Stage, commit, and push:

```text
/git add . --path=plugins/MyProject
/git commit -m=update-files --path=plugins/MyProject
/git push --path=plugins/MyProject
```

## Configuration

```yaml
# WARNING: Disabling this allows users to push to public Git hosts such as GitHub or GitLab.
disable-unsafe-warning: false
```

Public Git hosting is blocked by default when adding remotes. To allow GitHub or GitLab remotes, set:

```yaml
disable-unsafe-warning: true
```

## Permissions

Commands are available to server operators by default.

```text
gitcraft.command.help
gitcraft.command.init
gitcraft.command.remote
gitcraft.command.add
gitcraft.command.commit
gitcraft.command.reset
gitcraft.command.status
gitcraft.command.fetch
gitcraft.command.pull
gitcraft.command.push
gitcraft.command.login
gitcraft.command.whoami
gitcraft.command.logout
```

## License

All rights reserved.
