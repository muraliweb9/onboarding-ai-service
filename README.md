# onboarding-ai-service

## Useful links
[Open AI](https://platform.openai.com/docs/overview)<br>
[Open AI SpringBoot example](https://howtodoinjava.com/spring-boot/spring-openai-chatgpt-demo/)<br>
[Add SSH Keys](https://gitlab.com/-/user_settings/ssh_keys)<br>
[GitLab](https://gitlab.com/muraliweb/onboarding-ai-service)<br>
[GitLab Access Token](https://gitlab.com/-/user_settings/personal_access_tokens?name=GitLab+Duo+For+JetBrains&scopes=api)<br>

## IntelliJ run configuration

-Dchat.gpt.api.key=the-api-key
![img.png](docs/run-config.png)

## Generate SSH Key pair
```
C:\gitprojects\gitlab>ssh-keygen -t ed25519 -C "GitLab"
Generating public/private ed25519 key pair.
Enter file in which to save the key (C:\Users\Murali/.ssh/id_ed25519):
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in C:\Users\Murali/.ssh/id_ed25519.
Your public key has been saved in C:\Users\Murali/.ssh/id_ed25519.pub.
The key fingerprint is:
SHA256:+Xc+A8ttfOjqy+4y1LgIaepkRwrGnM7UNPI29yVrZ8c GitLab
The key's randomart image is:
+--[ED25519 256]--+
|                 |
|                 |
|  . o            |
| o * .   .       |
|  B = o.S .o     |
| = o =+. =o.o    |
|  o +o..+o+oE=.. |
|   o.. ..o++ooB .|
|   ..      *B=o+ |
+----[SHA256]-----+

C:\gitprojects\gitlab>ls
```

## Add SSH Key to GitLab
Add SSH Keys [Add SSH Keys](https://gitlab.com/-/user_settings/ssh_keys)
