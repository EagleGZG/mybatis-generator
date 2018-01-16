package com.wuj.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wujian on 15-7-16.
 */
public class PojosPlugin extends PluginAdapter implements Serializable {
    
    private static final long serialVersionUID = -1302411116234101995L;

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String serializableFullName = "java.io.Serializable";
        FullyQualifiedJavaType serializable = new FullyQualifiedJavaType(serializableFullName);
        topLevelClass.addSuperInterface(serializable);
        topLevelClass.addImportedType(serializableFullName);
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }
}
