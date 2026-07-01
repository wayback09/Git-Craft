# GitCraft

GitCraft is a Paper plugin that lets server admins and developers run Git commands directly from Minecraft using `/git`.

It is designed for managing server projects, configs, plugin folders, and other Git-backed files without leaving the game console or chat.

## Features

- Run Git commands in-game or from console
- Initialize repositories
- Add, commit, status, reset, fetch, pull, and push changes
- Manage the `origin` remote
- Store Git credentials securely using an encrypted H2 database
- Supports GitHub personal access tokens
- Permission-based command access
- Async Git operations to help avoid server lag
- Built for Paper `26.1.2`; `26.2` support should be verified with runtime testing

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
4. Initialize a repo:

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

## GitHub Token Setup

Create a GitHub personal access token with repository access.

For fine-grained tokens, use:

```text
Repository access: selected repository
Contents: read and write
Metadata: read-only
```

Then log in:

```text
/git login --username=YourUsername --token=YourToken
```

## Permissions

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

By default, commands are available to operators.

## Configuration

<details>
<summary>config.yml</summary>

```yaml
# WARNING: Disabling this allows users to push to public Git hosts such as GitHub or GitLab.
disable-unsafe-warning: false
```

</details>

## Security Notes

GitCraft stores credentials in an encrypted local H2 database inside the plugin data folder.

Public Git hosting is blocked by default when adding remotes. To allow GitHub or GitLab remotes, set:

<details>
<summary>Allow public Git hosts</summary>

```yaml
disable-unsafe-warning: true
```

</details>

Use this carefully. For production servers, self-hosted Git services such as Gitea or Forgejo are recommended.

## Requirements

- Paper server
- Paper `26.1.2` and `26.2` after testing
- Java `25` or newer

