import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * @author chenyao
 * @date 2023-10-18 11:30
 */
public class Test01
{
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mao?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                "root", "root")
            .globalConfig(builder -> {
                builder.author("mao") // 设置作者
                    .enableSwagger() // 开启 swagger 模式
                    .fileOverride() // 覆盖已生成文件
                    .outputDir("D:\\data\\mybatis"); // 指定输出目录
            })
            .packageConfig(builder -> {
                builder.parent("com.mayikt.edu") // 设置父包名
                    //                            .moduleName("system") // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\data\\mybatis")); // 设置mapperXml生成路径
            })
            //                .strategyConfig(builder -> {
            //                    builder.addInclude("t_simple") // 设置需要生成的表名
            //                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
            //                })
            //                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }
}
