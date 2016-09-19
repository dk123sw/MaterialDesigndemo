### 使用到了Navigation，ToolBar , TabLayout , DrawLayout
#### Toolbar
###### http://www.codeceo.com/article/android-toolbar-develop.html 
###### http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1118/2006.html
`实例github上AndroidSystemUiTraining`
#### 学习Navigation View(抽屉菜单)的操作
###### http://blog.csdn.net/u012702547/article/details/51253222
`github上start的MaterializeYourApp实例`
#### ActionBarDrawerToggle
###### http://blog.csdn.net/jjwwmlp456/article/details/41206513
#### 状态栏
###### http://blog.csdn.net/guolin_blog/article/details/51763825
#### 沉浸式状态栏
###### http://jaeger.itscoder.com/android/2016/02/15/status-bar-demo.html
###### http://blog.majiajie.me/2016/03/14/Android-%E6%B2%89%E6%B5%B8%E5%BC%8F%E7%8A%B6%E6%80%81%E6%A0%8F%E5%AE%8C%E7%BE%8E%E5%AE%9E%E7%8E%B0/
##### 5.0新控件FloatingActionButton，TextInputLayout，Snackbar，TabLayout 
###### http://blog.csdn.net/feiduclear_up/article/details/46500865
##### AppBarLayout，NavigationView，CoordinatorLayout，CollapsingToolbarLayout
http://blog.csdn.net/feiduclear_up/article/details/46514791
##### android design library提供的TabLayout的用法 
###### http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0731/3247.html

##### @id与@+id
`@+id
表示新增一个id，所以一般用在定义一个控件的id的时候。比如，android:id="@+id/textView1"，
表示新增一个叫做textView1的id，并且设置当前这个控件的id叫做textView1。
@id
表示引用一个id，一般用来指定某一个控件。比如，当放置一个B控件位于A控件的左边的时候，可以使用android:layout_toLeftOf="@id/A"，这里就是通过引用A的id来指明相对于哪个控件进行布局。`

##### 踩坑：
###### 隐藏状态栏时导致标题栏上移尝试多种方法失败，最后向toolbar上加入一个view视图填补状态栏的空缺
###### NavigationView中分组需要加上id属性才能出现分组线，而不加checkableBehavior属性会导致分组内的成员无法被选中。
###### ActionBarDrawerToggle是一个开关，用于打开/关闭DrawerLayout抽屉，用这个开关实现NavigationView和ToolBar共同使用
###### 活动界面需要实现onCreateOptionsMenu这个类来完成状态栏菜单的显示活动界面需要实现onCreateOptionsMenu这个类来完成状态栏菜单的显示
###### 目前在toolbar上设置标题logo都无效有可能是view创建的顺序导致toolbar上的设置被覆盖...
