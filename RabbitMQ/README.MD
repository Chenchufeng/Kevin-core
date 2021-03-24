#linux启动RabbitMQ服务：
systemctl start rabbitmq-server
systemctl restart rabbitmq-server
systemctl stop rabbitmq-server

#访问rabbitmq web管理界面
首先需要关闭linux服务器的防火墙
rabbitmq的默认端口是15672，服务器ip地址是47.119.120.170
开启rabbitmq server后，在浏览器输入47.119.120.170:15672
username:guest
password:guest

#Centos7默认安装了firewalld，如果没有安装的话，可以使用 yum install firewalld firewalld-config进行安装。
1.启动防火墙
systemctl start firewalld

2.禁用防火墙
systemctl stop firewalld

3.设置开机启动
systemctl enable firewalld

4.停止并禁用开机启动
systemctl disable firewalld

5.重启防火墙

firewall-cmd --reload

6.查看状态
systemctl status firewalld或者 firewall-cmd --state

7.查看版本
firewall-cmd --version

8.查看帮助
firewall-cmd --help

#amqp协议
![img.png](img.png)

#虚拟主机(主机名：Kevin)
Kevin用户（pwd:123 ）,需要给新船舰的用户绑定一个虚拟主机