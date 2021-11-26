# WebApp





- 接收一个roll number（可能是ID之类），显示name、department

  以表格形式列出所有上过的课：course id，title，credits，grade（show blank if grade is null）

- 给出一个word， 找到所有包含该词的课程信息（可以像上述一样在一个表单中列出）

- 找到挂了两科及以上的同学（可以在学生信息下面列出表格：课程信息）

- 插入一个学生记录（a roll number, name and department name, and tot_creds set to 0），有报错功能（用不存在的department测试foreign key，用重复的roll number（ID）测试primary key

  

  创建生成 HTML 的函数而不是直接编写

- 编写一个函数 createDropDown(ResultSet)，它接受一个 ResultSet，并从 ResultSet 创建一个下拉菜单；第一个属性用作结果值，所有属性都显示在下拉菜单中，并连接在一起

- 还要编写一个函数 createDropDown(String) 来做同样的事情，但它不是 ResultSet，而是将 SQL 查询作为字符串；只要查询不涉及用户输入的任何值，第二个版本就可以安全使用，否则容易受到SQL注入攻击。

- 创建表单界面以插入学生和教师表的记录，并带有系名称的下拉菜单，显示所有有效的系名称。和以前一样，异常应该被捕获和报告