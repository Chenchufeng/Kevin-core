#HttpServletRequest 详解
HttpServletRequest对象代表客户端的请求，当客户端通过HTTP协议访问服务器时，HTTP请求头中的所有信息都封装在这个对象中，通过这个对象提供的方法，可以获得客户端请求的所有信息。
获得客户机信息：

**getRequestURL()	返回客户端发出请求时的完整URL。  
getRequestURI()	返回请求行中的参数部分。  
getQueryString ()	方法返回请求行中的参数部分（参数名+值）  
getRemoteHost()	返回发出请求的客户机的完整主机名。  
getRemoteAddr()	返回发出请求的客户机的IP地址。  
getPathInfo()	返回请求URL中的额外路径信息。额外路径信息是请求URL中的位于Servlet的路径之后和查询参数之前的内容，它以"/"开头。  
getRemotePort()	返回客户机所使用的网络端口号。  
getLocalAddr()	返回WEB服务器的IP地址。  
getLocalName()	返回WEB服务器的主机名。**  
***

#HttpServletResponse对象介绍
Web服务器收到客户端的http请求，会针对每一次请求，分别创建一个用于代表请求的request对象、和代表响应的response对象。
request和response对象即然代表请求和响应，那我们要获取客户机提交过来的数据，只需要找request对象就行了。要向客户机输出数据，只需要找response对象就行了。

#request.getSession()
1、request.getSession()可以帮你得到HttpSession类型的对象，通常称之为session对象，session对象的作用域为一次会话，通常浏览器不关闭，保存的值就不会消失，当然也会出现session超时。  
服务器里面可以设置session的超时时间，web.xml中有一个session time out的地方，tomcat默认为30分钟  
2、session.setAttribute("key",value)；是session设置值的方法，原理同java中的HashMap的键值对，意思也就是key现在为“user”；存放的值为userName，userName应该为一个String类型的变量吧，看你自己的定义。  
3、可以使用session.getAttribute("key");来取值，以为着你能得到userName的值。  
4、注意：getAttribute的返回值类型是Object，需要向下转型，转成你的userName类型的，简单说就是存什么，取出来还是什么。   
5、setAttribute和getAttribute就是基于HashMap的put方法和get方法实现的，一般叫键值对或者key-value，即通过键找到值。例如你的名字和你的人的关系，只要一叫你的名字，你就会喊到，通过你的名字来找你的人，简单说这就是键值对的概念  