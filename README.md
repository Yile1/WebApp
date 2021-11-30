# WebApp

#### 功能要求

- 接收一个roll number（可能是ID之类），显示name、department

  以表格形式列出所有上过的课：course id，title，credits，grade（show blank if grade is null）√

- 给出一个word， 找到所有包含该词的课程信息（可以像上述一样在一个表单中列出）√

- 找到挂了两科及以上的同学（可以在学生信息下面列出表格：课程信息）---------------待测试  √

- 插入一个学生记录（a roll number, name and department name, and tot_creds set to 0），有报错功能（用不存在的department测试foreign key，用重复的roll number（ID）测试primary key-----编写一个exist函数  √

创建生成 HTML 的函数而不是直接编写  

- 编写一个函数 createDropDown(ResultSet)，它接受一个 ResultSet，并从 ResultSet 创建一个下拉菜单；第一个属性用作结果值，所有属性都显示在下拉菜单中，并连接在一起   
- 还要编写一个函数 createDropDown(String) 来做同样的事情，但它不是 ResultSet，而是将 SQL 查询作为字符串；只要查询不涉及用户输入的任何值，第二个版本就可以安全使用，否则容易受到SQL注入攻击。  √
- 创建表单界面以插入学生和教师表的记录，并带有系名称的下拉菜单，显示所有有效的系名称。和以前一样，异常应该被捕获和报告  √



#### 代码结构

主要代码结构如下：

```
|- WebApp_Lab
|
|	|- src
|		|- pers
|			|- pojo
|				|- Student.class: 构建Student对象的JavaBean
|				|- Course.class: 构建Course对象的JavaBean
|				|- Instructor.class: 构建Instructor对象的JavaBean
|			|- utils
|				|- JdbcUtils.class: 提供数据库连接的工具类
|			|- dao
|				|- impl
|					|- BaseDao.class: 数据库操作的基础类
|					|- UniversityDaoImpl.class:	查找操作university数据库的接口实现
|				|- UniversityDao.interface: 查找操作university数据库的接口
|			|- service
|				|- impl
|					|- UniversityServiceImpl.class: web功能接口实现
|				|- UniversityService.interface: web功能接口
|			|- test
|				|- JdbcUtilsTest.class: JdbcUtils类测试
|				|- UniversityDaoImplTest.class: UniversityDaoImpl类测试
|			|- web
|				|- StudentServlet.class: 查找学生信息的Servlet程序
|				|- CourseServlet.class: 查找课程信息的Servlet程序
|				|- InsertServlet: 插入学生、教师信息的Servlet程序
|				|- DeptServlet: 查找院系的Servlet程序
|				|- SqlServlet: 利用sql查询的Servlet程序
|
|		|- jdbc.properties: 数据库配置信息
|
|	|- webapp
|		|- static
|			|- main.js: vue程序
|			|- jquery-1.7.2.js
|		|- WEB-INF
|			|- lib: 项目所需jar包
|			|- web.xml: servlet配置
|		|- index.html: web主页面
|
|	|- README.md: 项目说明文档
```



#### 待解决

- 先搜索存在再搜索不存在为什么courses不存在数据了？不应该还存在上次数据吗？
- courses初始赋值为”数据不存在”时vue无法渲染
- 下拉系菜单   √
- 改样式（分割线，缩小字符所占空间） √
- 注释
- if报错等步骤
- 中文乱码
- createDropDown（只读sql）√





