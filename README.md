# Re-McLogin

## A pull request was created for this repositories to molaeiali:master because of my mistake. I'm so sorry.:<
## I think I need to learn "How to use Github"

![Re-McLogin_ICON](https://raw.githubusercontent.com/VmLuRui262/Re-mclogin/master/src/main/resources/assets/remclogin/icon.png)

[![LICENSE](https://raw.githubusercontent.com/VmLuRui262/Re-mclogin/master/svg/LICENSE.svg)](https://raw.githubusercontent.com/VmLuRui262/Re-mclogin/master/LICENSE)

**English** | [中文](https://github.com/VmLuRui262/Re-mclogin/blob/master/README_cn.md)

[Fabric](https://fabricmc.net/) mod for [Minecraft: Java Edition](https://www.minecraft.net/) to protect offline mode servers adding `/l` and `/reg`. This is a server-side mod, clients don't have to download it.

If you like this repositories, please give a star⭐️ .

##  Requirement

- [Fabric-Api](https://minecraft.curseforge.com/projects/fabric/)

## Features
- Add language files
- Add UserName TAB autocomplete for `/dereg`
## Commands
- /reg `<newPassword>` `<confirmPassword>`
- /l `<password>`
- /passwd `<oldPassword>` `<newPassword>` `<confirmPassword>`
- /dereg `<UserName>`*OP Only, [CI Build](https://github.com/VmLuRui262/Re-mclogin/releases/tag/CI-2.0.0) has added this command.
## Build
You need to install JDK18.

- Windows: `git clone https://github.com/VmLuRui262/Re-mclogin.git && cd .\Re-mclogin && .\gradlew.bat build`

- Linux: `apt install -y openjdk-18-jdk && git clone https://github.com/VmLuRui262/Re-mclogin.git && cd ./Re-mclogin && ./gradlew build`
## Thank
Without them there would be no  this repo.

- [molaeiali](https://github.com/molaeiali) / [mclogin](https://github.com/molaeiali/mclogin)
- [Londiuh](https://github.com/Londiuh) / [login](https://github.com/Londiuh/login)
