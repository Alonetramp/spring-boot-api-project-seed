import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.company.project.core.ProjectConstant.*;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/24 0024 17:51
 */
public class TemplateMap {

    //模板中出现的变量
    private Map<String, Object> data;

    private static final String AUTHOR = "CodeGenerator";//@author
    private static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());//@date

    public TemplateMap(){
        data = new HashMap<>();
        data.put("date", DATE);
        data.put("author", AUTHOR);
        data.put("basePackage", BASE_PACKAGE.replaceAll("main.java.",""));
        data.put("modelPackage", MODEL_PACKAGE.replaceAll("main.java.",""));//Model包名
        data.put("mapperPackage", MAPPER_PACKAGE.replaceAll("main.java.",""));//Mapper包名
        data.put("servicePackage", SERVICE_PACKAGE.replaceAll("main.java.",""));//Service包名
        data.put("serviceImplPackage", SERVICE_IMPL_PACKAGE.replaceAll("main.java.",""));//ServiceImpl包名
        data.put("controllerPackage", CONTROLLER_PACKAGE.replaceAll("main.java.",""));//Controller包名
        data.put("springbootApplication","Application");//springboot的启动类名称，用于测试模板
    }

    public Map getDataMap(){
        return data;
    }

    public Map<String, Object> put(String string, Object object){
        data.put(string,object);
        return data;
    }

}
