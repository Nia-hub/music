package util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class MybatisPlusGenerator {

    final static String dirPath = System.getProperty("user.dir");//系统会获取当前项目的项目根目录例：F:\02_myProjectWorkspace\music

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {

        AutoGenerator autoGenerator = new AutoGenerator();

        // 选择 freemarker 引擎，默认 Veloctiy
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 1.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("142128");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/music?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
        autoGenerator.setDataSource(dataSourceConfig);

        // 2.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(dirPath + "/src/main/java/");//包生成路径
        globalConfig.setAuthor("ganwei");
        globalConfig.setFileOverride(true); //是否覆盖
        globalConfig.setEnableCache(false);// XML 二级缓存
        globalConfig.setBaseResultMap(true);// XML ResultMap
        globalConfig.setBaseColumnList(true);// XML columList
        globalConfig.setOpen(false);//设置为创建完文件不默认打开文件
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sMapper");
        // gc.setServiceName("%sService");//生成的service接口不会带I
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        autoGenerator.setGlobalConfig(globalConfig);

        // 3.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix("t_", "sys_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略song_list生成SongListController
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//列名规则 字段user_name对应属性userName
        strategy.setEntityLombokModel(true);//是否生成lombok注解
        strategy.setRestControllerStyle(true);//开启驼峰命名
        strategy.setInclude("t_admin"); // 需要生成的表，如果 setInclude() 不加参数, 会自定查找所有表
        autoGenerator.setStrategy(strategy);

        // 4.包配置,各种包的生成路径（controller，service，dao等）
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.nia.music.sys");
        packageConfig.setModuleName("admin");//整个模块的包名
        packageConfig.setController("controller");//包内的controller包名
        packageConfig.setEntity("entity");//包内的entity包名
        packageConfig.setMapper("dao");//包内的dao包名
        packageConfig.setService("service");//包内的service包名
        //packageConfig.setServiceImpl("serviceImpl");//包内的serviceImpl包名默认放在service下的serviceImpl包内
        packageConfig.setXml("dao/xml");//xml放在自动会放在mapper的xml包内
        autoGenerator.setPackageInfo(packageConfig);

        // 执行生成
        autoGenerator.execute();
    }

}
