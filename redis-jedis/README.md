#linux查看redis安装目录 和redis关闭
如果命令 which 和whereis 都找不到安装目录，可使用以下办法  
ps -ef|grep redis  
得到了进程号 xxxx  
然后 ls -l /proc/xxxx/cwd  

查看redis-cli 和redis-server的目录则使用whereis redis-cli
关闭redis. :  
1.先进入redis   ./redis-cli   输入密码   auth   '密码'
2.  shutdown
如果直接在目录中使用  ./redis-cli shutdown 是关闭不了的  
模糊查询使用find    : find / -name redis*   其中:   /  指的是根目录  

