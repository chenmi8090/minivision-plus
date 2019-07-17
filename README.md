Reus说明：
1.双击点开Reus.exe运行文件后会弹出cmd命令窗口,此时的Reus会在此运行窗口处运行。
2.启动后Reus会自动弹出默认浏览器启动Reus页面,如果需要结束Reus,关闭cmd命令窗口或Ctrl+c均可关闭。

Reus使用说明：
1.弹出页面后进行登陆。
2.首先点击左上角的添加连接按钮,完善数据库连接信息;(eg:Schema/数据库='sms_prod')
3.点击连接信息后会在下方展示当前数据库中的所有表信息。
4.点击表信息后会将基本信息映射到中心的参数配置上。
5.中心的参数配置可以选择是否生成(红色:不生成、绿色:生成)。
6.完善配置后点击生成即可。

注：点击不生成后可以不选择当前模块的路径、包名等信息。


Reus开发流程：
1.Git上有一份代码为:Minivision-Plus,该代码为MyBatis-Plus的源码,Minivision-Plus为修改后的版本;
	源码地址：
2.源码中有几个比较关键的类对象(以下类均在Minivision-Plus中的generator模块中)
	①AutoGenerate ：当前类为主执行类,里面的execute()方法执行生成文件时会带上我们的配置,下面都是配置类。
	②GlobalConfig ：当前类为全局配置类,里面有生成文件的部分属性(默认输出路径、各个生成类的类名、各个类的输出Path集合等)
	③DataSourceConfig ：当前类为数据库配置类,里面有连接数据库的配置,具体数据由前台传递。
	④PackageConfig ：当前类是重点,里面存放着各个生成类的包路径(后续扩展可在此扩展)。
	⑤TemplateConfig ：当前类是模板类,里面的XXXIsGenerator属性决定了当前类是否生成,其余内容则是选择当前生成的模板。
	⑥InjectionConfig ：当前类是自定义配置类,当前类可以设置Xml文件的生成路径。
	⑦StrategyConfig ：当前类为策略配置类,里面包含生成的类的属性配置(命名驼峰、属性驼峰、注解配置、主键配置、表前缀设置等待)。
3.前台页面书写的位置为Reus-Web项目中的/src/views/code/index.vue中。
4.前台页面完成后运行npm run build命令,将打包好的dist下的static文件夹以及favicon.ico、index.html三个文件一起拖进Reus项目的static文件夹目录下
(Reus项目的static文件夹下有static文件夹、favicon.ico、index.html)
5.以上都完成后点击Idea的File->Project Structure->Artifacts
	①点击加号("+")后点击第一个JAR->From modules with dependencies。
	②Module选择Reus项目
	③Main Class选择ReusApplication。
	④JAR files from libraries 选择第二项copy to...会将当前项目的jar以及当前项目使用的jar输出在当前项目的out/artifacts/reus_jar目录下。
	⑤Directory for META-INF/MANIFEST.MF 将路径后面的java修改为resources,让MANIFEST.MF文件生成在resources目录下(如果已经存在需要删除)。
	⑥完成后点击右下角Apply即可。
	⑦点击Idea中的Build->Build Artifacts 选择Reus后点击Build即可,会将当前项目的jar和使用jar一同生成在当前项目的out/artifacts/reus_jar目录下。
6.获取到当前项目的所有Jar后需要运行Exe4J软件将其转换为exe可执行文件。具体操作看"Exe4J使用说明.docx"。
	
	
	
	
	
