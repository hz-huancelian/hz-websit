package com.hz.websit;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @Project : chem-erp
 * @Description :
 * @Author : chh
 * @Iteration :
 * @Date : 2021-02-10
 * @ModificationHistory Who          When          What
 */
public class Generatortest {
    @Test
    public void generateTest(){
        //全局配置
        GlobalConfig config = new GlobalConfig();
        //设置是否支持AR模式
        config.setActiveRecord(true)
                //设置生成代码的作者
                .setAuthor("gzh")
                //设置输出代码的位置
                .setOutputDir("f:output")
                //设置是否覆盖原来的代码
                .setFileOverride(true);

        //******************************数据源配置***************************************
        //数据库连接url
        String dbUrl = "jdbc:mysql://8.136.159.136:3306/hz_db_web?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8";
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //数据库类型 枚举
        dataSourceConfig.setDbType(DbType.MYSQL)
                //设置url
                .setUrl(dbUrl)
                //设置用户名
                .setUsername("administrator")
                //设置密码
                .setPassword("156156Qpzmxzz")
                //设置数据库驱动
                .setDriverName("com.mysql.cj.jdbc.Driver")
                // 自定义数据库表字段类型转换【可选】
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        //tinyint转换成Boolean
                        if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                            return DbColumnType.BOOLEAN;
                        }
                        //将数据库中datetime转换成localDatetime
                        if ( fieldType.toLowerCase().contains( "datetime" ) ) {
                            return DbColumnType.LOCAL_DATE_TIME;
                        }

                        return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
                    }
                });


        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                //全局大写命名是否开启
                .setCapitalMode(true)
                //【实体】是否为lombok模型
                .setEntityLombokModel(true)
                //表名生成策略  下划线转驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                //自动填充设置
                //.setTableFillList(tableFillList)
                //修改替换成你需要的表名，多个表名传数组
//                .setInclude("t_shop_cart");
                .setInclude(new String[]{"w_quote_middle", "w_quote_bottom","w_customer","w_adver","w_server_customer","w_customer_seek","w_user"});
        //集成注入设置
        //注入全局设置
        new AutoGenerator().setGlobalConfig(config)
                //注入数据源配置
                .setDataSource(dataSourceConfig)
                //注入策略配置
                .setStrategy(strategyConfig)
                //设置包名信息
                .setPackageInfo(
                        new PackageConfig()
                                //提取公共父级包名
                                .setParent("com.hz.websit")
                                //设置controller信息
                                .setController("controller")
                                //设置实体类信息
                                .setEntity("entity")
                )
                .execute();
    }

}
