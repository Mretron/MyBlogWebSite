# MyBlogWebSite
基于SpringBoot的精美个人博客网站
感谢对我的博客网站感兴趣的你。
下载项目运行提示:
  因为项目涉及到个人隐私，所以上传的时候做了如下修改：
    1.修改了mysql连接密码
    2.修改了ssl认证文件等java方法
    
运行忠告：
  1.下载整个项目过后，请首先根据表结构构建相应的数据库表，并且在t_user表中插入一条信息
    注意：第一次需要自己增加MD5加密过后的密码格式，相应的MD5加密算法在项目中的src/main/java/com.zzj.blog/util/MD5Utils中可以找到
  2.修改application的端口号，好让项目在你的电脑环境运行(application-dev.yml开发环境，application-pro.yml生产环境)
  3.通过访问localhost:你的端口号/admin进行访问后台管理，可以进行编辑博客等操作
  4.通过访问localhost:你的端口号 进行访问整个网站的对外首页
  
  
非常荣幸能得到你的青睐，在此希望能为你带来帮助的我一个star~
  
  
