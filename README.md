# MyBlogWebSite
项目地址：www.zengzhongjie.com<br>
GitHub源码下载地址：https://github.com/Mretron （能够帮上忙，不妨star一下）

感谢对我的博客网站感兴趣的你。

下载项目运行提示:
  因为项目涉及到个人隐私，所以上传的时候做了如下修改：
- 修改了mysql连接密码
- 修改了ssl认证文件等java方法
    
运行忠告：
- 下载整个项目过后，请首先根据表结构构建相应的数据库表，并且在t_user表中插入一条信息
    注意：第一次需要自己增加MD5加密过后的密码格式，相应的MD5加密算法在项目中的src/main/java/com.zzj.blog/util/MD5Utils中可以找到
- .修改application的端口号，好让项目在你的电脑环境运行(application-dev.yml开发环境，application-pro.yml生产环境)
- .通过访问localhost:你的端口号/admin进行访问后台管理，可以进行编辑博客等操作
- 通过访问localhost:你的端口号 进行访问整个网站的对外首页
  
  
非常荣幸能得到你的青睐，在此希望能为你带来帮助的我一个star~



 > 作者：曾中杰

------------


> 有多少人只顾着眼前的六便士，却不曾抬头看看皎洁的月亮

<br>
<br>
项目地址：www.zengzhongjie.com<br>
GitHub源码下载地址：https://github.com/Mretron （能够帮上忙，不妨star一下）

#### 背景：
&nbsp;&nbsp;&nbsp;&nbsp;博主是一名大二软件工程的学生。坚持学习课堂上未曾教授的java以及javaweb相关的知识，乃至学习Spring一系列的框架的过程尤为枯燥。每天看视频学习编程，“copy”视频中的代码运行让我就像是机器一样日复一日地重复着那些操作。而使得我能够坚持下去的兴趣，就是能够在不久的将来完成我自己的项目。也就有了我的个人博客网站。
#### 网站一览：
##### 首页
![](http://123myblog.oss-cn-beijing.aliyuncs.com/%E9%A6%96%E9%A1%B5%E6%88%AA%E5%9B%BE.png)


<br>

##### 分类页面

![](http://123myblog.oss-cn-beijing.aliyuncs.com/%E5%88%86%E7%B1%BB%E9%A1%B5%E9%9D%A2.png)

<br>

##### 归档页面

![](http://123myblog.oss-cn-beijing.aliyuncs.com/%E5%BD%92%E6%A1%A3%E9%A1%B5%E9%9D%A2.png)

<br>

##### 后台管理页面

![](http://123myblog.oss-cn-beijing.aliyuncs.com/%E5%90%8E%E5%8F%B0%E9%A1%B5%E9%9D%A2.png)

<br>

##### 后台发布文章页面

![](http://123myblog.oss-cn-beijing.aliyuncs.com/%E7%BC%96%E5%86%99%E6%96%87%E7%AB%A0.PNG)

#### 技术组合：
- 后端：SpringBoot + Mysql + JPA + Maven + 阿里云OSS + thymeleaf模板
- 前端：Semantic UI框架 + html + css + js + jQuery + editor.md等

#### 插件集成（相关下载地址后文提到）
- 编辑器 markdown
- 内容排版 typo
- 动画 animate
- 代码高亮 prism
- 目录生成 Tocbot
- 滚动侦测 waypoints
- 平滑滚动 jquery.scrollTo
- 二维码生成 qrcode.js
- MarkDown转HTML
- 简单的爬虫技术实现翻译单词功能 jsoup.jar

#### 工具与环境:
- IDEA
- Maven 3
- JDK 8

#### 从中有什么收获？
- 基于SpringBoot的完整全栈式的开发套路
- Semantic UI框架的使用
- 后端使用SpringBoot+JPA，相比于SSM框架大量的配置开发更为方便，作为新手练手的javaweb项目来说是富有意义的：*激发自己编程热情+熟悉SpringBoot整个开发流程+完成过后提高自己的成就感*。
- JPA的简单使用（JPA和MyBatis的对比，其实就是Hibernate和MyBatis的对比，对于*数据的操作，hibernate是面向对象的，而MyBatis是面向关系的*。对于我的个人博客网站来说，面向对象更为方便自己理解业务逻辑，开发过程中建表也更为方便）。
- 懂得根据需求去GitHub上面使用优秀的*开源插件*，使得自己的项目锦上添花。
- 对页面引擎 *thymeleaf模板 的熟悉掌握*。相比于连SpringBoot都官方遗弃的jsp来说，掌握thymeleaf是刻不容缓的。（JSP本质上是servlet，内含java代码，实际上没有做到前后端分离，所以在大环境都推崇前后端分离的情况下，着实不必再使用JSP）
- 与我而言，最大的收获便是在茫茫互联网的大海里面，有了属于我的一叶扁舟，能够在扁舟上不断地*分享我的故事*给陌生人，老朋友，便是我的荣幸。

#### 小福利
通过此次开发个人博客网站，除了学会集成上面提到的一些开源优秀插件，还有一些实用但是鲜有人知的对开发起到锦上添花的网站。在此分享给大家。
- Font Awesome : 小图标icon网站，你想要的精美小图标，应该都能找到 https://fontawesome.com/
- Subtle Patterns ：全是精美设计的背景图 https://www.toptal.com/designers/subtlepatterns/


# 1、需求与功能

### 1.1个人博客系统的用户故事：

**角色**：普通访客，管理员(我)

> 普通访客：
- 查看所有发布的博客
- 查看博客的公布的所有信息
- 所有博客分类
- 所有博客标签
- 根据年份划分的博客信息
- 所有友链的信息
- 根据权限访问首页“小世界”模块
- 首页公告板
- 访问关于我和关于本站的页面
- 查看所有留言的侧边栏和提供留言的版块
- 全局搜索所有的博客
- 查看我分享的所有信息，如：二维码，导向至GitHub，csdn,微博的图标等


> 管理员(我):
- 根据账号密码登录后台管理
- 后台增删改查所有博客
- 后台增删改查所有分类
- 后台增删改查所有便签
- 后台增删改查公告板
- 后台增删改查留言
- 后台增删改查友链信息
- 后台增删改查自己的信息

### 1.2功能规划
![](http://123myblog.oss-cn-beijing.aliyuncs.com/%E9%9C%80%E6%B1%82%E5%88%86%E6%9E%90.png)

# 2、页面设计与开发

### 2.1设计
> 页面规划：
- 前端展示:首页、分类页、标签页、归档页、本站、友链。关于我
- 后台管理：登录页面、博客管理、分类管理、标签管理、公告管理、友链管理、留言管理、个人信息管理

### 2.2页面开发


- Semantic UI官网 https://semantic-ui.com/
- Semantic UI中文官网 https://onebugman.cn/semantic-ui/
- 背景图片资源 https://www.toptal.com/designers/subtlepatterns/

|  前端相关 |  名称 |
| ------------ | ------------ |
|  前端框架 |  Semantic UI |
|  编译器 |  WebStorm |
|  页面语言 |  html+css+js |

### 2.3插件集成

| 介绍  | 名称  | 获取地址  |
| ------------ | ------------ | ------------ |
|  内容排版 |  typo.css |  https://github.com/sofish/typo.css |
|  动画 |  animate.css | https://daneden.github.io/animate.css/  |
|  代码高亮 |  prism |  https://github.com/PrismJS/prism |
|  目录生成 |  Tocbot |  https://tscanlin.github.io/tocbot/ |
|  滚动侦测 |  waypoints | http://imakewebthings.com/waypoints  |
|  平滑滚动 |  jquert.scrollTo |  https://github.com/flesler/jquery.scrollTo  |
|  二维码生成 | qrcode.js  | https://davidshimjs.github.io/qrcodejs/  |
|  编辑器|  MarkDown |  https://pandao.github.io/editor.md   |

# 3、框架搭建
### 3.1构建
> IDEA 引入SpringBoot模块
- web  ：springboot集成了tomcat和springmvc的一些模块 
- Thymeleaf ： 前端的模板 和jsp的最终的目的一样的
- Jpa ： 规范数据操作的工具
- MySql ：数据库
- Aspects ： 集成SpringAOP的模块，这里使用切面来实现日志
- DevTools：热部署，帮助我们开发过程中不用每次都重新启动项目启动

### 3.2异常处理
> 错误页面：
- 404： 访问的资源不存在或者页面不存在，这种情况跳转404
- 500： SpringBoot后台发生了一些异常信息的时候跳转的页面，这种跳转500
- ERROR： 我们自己定义的错误页面，方便开发者调试，可以便捷的查看

### 3.3日志处理
> 记录日志内容
- 请求url
- 访问者ip
- 调用方法 classMethod
- 参数args
- 返回内容

# 4、设计与规范

### 4.1实体设计

实体类
- 博客Blog
- 博客分类Type
- 博客标签Tag
- 博客评论Comment
- 用户User
- 公告栏Bulletin
- 朋友Friend
- 留言Message

举例两个数据库表：

博客表t_blog


| 名称  |类型   | 长度  |主键   |非空   | 描述  |
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------ |
| id  | bigint  |  20 | true  | true  |  作为主键 |
| appreciation |  bit  | 1  | false  |  true | 是否开启赞赏  |
| commentabled  |  bit | 1  | false  |  true | 是否开启评论  |
| content  |  longtext |  0 | false  |  true | 文章的正文  |
| create_time  |  datetime | 0  | false  | true  | 文章创建时间  |
| first_pricture  |  varchar | 255  |  false |  true  | 文章的首图地址  |
| flag  | varchar  | 255  | false  |  true | 文章的类型原创,转载,翻译  |
| published  |  bit | 1  | false  | true  |  文章是否发布 |
| share_statement  |  bit | 1  | false  | true  | 版权声明  |
| title  | varchar  | 255  | false  |   true| 文章的标题  |
| update_Time  | datetime  | 0  | false  | true  | 最近更新时间  |
| views  | int  | 11  | false  |  true | 浏览量  |
| recommend  | bit  | 1  | false  |   true| 是否推荐  |
| description  | varchar  | 255  |   false|  true  | 文章的主要描述  |

用户表t_user

| 名称  |类型   | 长度  |主键   |非空   | 描述  |
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------ |
| id  | bigint  |  20 | true  | true  |  作为主键 |
| create_time  |  datetime | 0  | false  | true  | 用户创建时间  |
| avatar  |  varchar | 255  |  false |  true  | 用户的头像地址  |
| type  | varchar  | 255  | false  |  true | 用户的类型  |
| nickname  |  varchar | 255  | false  | true  | 用户的昵称 |
| username  |  varchar | 255  | false  | true  | 用户的实际名称  |
| update_Time  | datetime  | 0  | false  | true  | 最近更新时间  |
| email  | varchar  | 255  |   false|  true  | 用户的邮箱地址  |

### 4.2应用分层

![](http://123myblog.oss-cn-beijing.aliyuncs.com/%E5%BA%94%E7%94%A8%E5%88%86%E5%B1%82.png)

# 5、开发流程
### 5.1开发
- 刚开始使用手绘或者专门的画图工具画出网站的原型
- 在WebStorm中通过semantic UI根据设计的原型将前端网页码出来
- 接着使用IDEA，构建SpringBoot环境进行后端的编写
> 1. dao持久层通过接口继承JPARepository即可得到CRUD的标准方法，如果需要特定的查询方法，根据Jpa命名规则或者使用@Query注解即可
> 2. service业务逻辑层先编写一系列接口及其想实现的方法，再通过类去实现相应的接口，注意添加@Service注解放进IOC容器中。提供给Controller层调用
> 3. 在service业务逻辑层的实体类中的方法加上@Transactional事务注解，实现开启事务
> 4. Web层的Controller再通过依赖注入service即可完成相应的业务逻辑
> 5. 通过thymeleaf前端引擎进行渲染数据 

- 后端完成过后，进行整体细节处理，进一步完善整个网站的正常运行

### 5.2部署
- 采用的是SpringBoot自带的 jar包的 部署方式
- 通过maven 的 intall 命令得到 xxx.jar
- 放到阿里云Linux服务器中
- 使用 nohup java -jar xxx.jar & 命令 使得项目可以后台运行

# 值得一提
- 对于这个项目的开发能够较为顺利地进行，得益于李仁密老师的网络视频，在此特地感谢他。
- Semantic UI 是一种语义化的前端框架，只要稍微熟悉，就能构建精美的页面，特此感谢semantic UI。
- 作为一名java后端人员，前端免不了遇到各种各样的错误，在此感谢我的前端大佬好朋友龚皓的支持，帮助我解决了很多前端的问题。
- 整个项目完成过后，最为让我煎熬的居然是备案。在大陆的网络服务器要想和你的域名进行DNS绑定，必须经过备案，而港澳台等地则不需要。而备案过程中耗时最长的便是邮寄资料过去，等待阿里审核更新你的网站备案信息。


# 不足之处：
- 页面还是因为不熟悉前端底层，有一些bug需要修复
- 后端只是基本的逻辑实现，接下来需要加入新的技术，提高整体网站的性能。如：Redis缓存实现
- 针对博客页面的二级回复目前待完善。
- 博客的首页小世界栏目页面待完成。
- 上传图片到阿里云OSS存储对象的功能待完成。
- 全局搜索博客的功能待完成。
- SSL认证,http自动转https(完成)
- 各种语言代码都支持高亮显示(完成)
- 文章页面增加翻译单词功能(完成)


> 
秉承开源原则，该项目完整代码均能在我的github上面下载得到。能够帮到有需要的朋友那是再好不过。
觉得博主的分享还不错，不妨在github上star一下博主，激励博主更新更多实用的功能。
https://github.com/Mretron
