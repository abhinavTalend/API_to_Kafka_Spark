package org.talend.designer.codegen.translators.generic.component;

import org.talend.core.model.process.INode;
import org.talend.core.runtime.IAdditionalInfo;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.core.model.components.EParameterName;
import org.talend.designer.core.model.components.ElementParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;

public class ComponentBegin
{
  protected static String nl;
  public static synchronized ComponentBegin create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentBegin result = new ComponentBegin();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "final org.talend.sdk.component.runtime.manager.ComponentManager mgr_";
  protected final String TEXT_3 = " = org.talend.sdk.component.runtime.manager.ComponentManager.instance();" + NL + "if (mgr_";
  protected final String TEXT_4 = ".getContainer().findAll().isEmpty()) {" + NL + "    mgr_";
  protected final String TEXT_5 = ".autoDiscoverPlugins(false, true);" + NL + "}" + NL + "" + NL + "final org.talend.sdk.component.runtime.record.RecordConverters.MappingMetaRegistry registry_";
  protected final String TEXT_6 = " = new org.talend.sdk.component.runtime.record.RecordConverters.MappingMetaRegistry();" + NL;
  protected final String TEXT_7 = NL + "final java.util.Map<String, String> configuration_";
  protected final String TEXT_8 = " = new java.util.HashMap<>();" + NL + "final java.util.Map<String, String> registry_metadata_";
  protected final String TEXT_9 = " = new java.util.HashMap<>();";
  protected final String TEXT_10 = NL + "                        configuration_";
  protected final String TEXT_11 = ".put(\"";
  protected final String TEXT_12 = "\",";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "                        registry_metadata_";
  protected final String TEXT_15 = ".put(\"length\", \"";
  protected final String TEXT_16 = "\");" + NL + "                        registry_metadata_";
  protected final String TEXT_17 = ".put(\"precision\", \"";
  protected final String TEXT_18 = ".put(\"pattern\", \"";
  protected final String TEXT_19 = "\");";
  protected final String TEXT_20 = NL + "                                configuration_";
  protected final String TEXT_21 = "[";
  protected final String TEXT_22 = "].label\", \"";
  protected final String TEXT_23 = "].originalDbColumnName\", \"";
  protected final String TEXT_24 = "].pattern\", \"";
  protected final String TEXT_25 = "].defaultValue\", \"";
  protected final String TEXT_26 = "].key\", \"";
  protected final String TEXT_27 = "].nullable\", \"";
  protected final String TEXT_28 = "].talendType\", \"";
  protected final String TEXT_29 = "].type\", \"";
  protected final String TEXT_30 = "].length\", \"";
  protected final String TEXT_31 = "].precision\", \"";
  protected final String TEXT_32 = "].comment\", \"";
  protected final String TEXT_33 = NL + "                            configuration_";
  protected final String TEXT_34 = "]\", \"";
  protected final String TEXT_35 = NL + "                // ";
  protected final String TEXT_36 = " is hidden, skipping.";
  protected final String TEXT_37 = NL + "                    globalMap.putIfAbsent(\"MAX_BATCH_SIZE_";
  protected final String TEXT_38 = "\", Integer.parseInt(";
  protected final String TEXT_39 = "));";
  protected final String TEXT_40 = NL + "                    configuration_";
  protected final String TEXT_41 = "\", ";
  protected final String TEXT_42 = NL + "            final java.util.Map<String, String> config_from_connection_";
  protected final String TEXT_43 = " = (java.util.Map<String, String>)globalMap.get(\"configuration_";
  protected final String TEXT_44 = "\");" + NL + "            final String conn_param_prefix_";
  protected final String TEXT_45 = " = \"";
  protected final String TEXT_46 = "\";" + NL + "            if(config_from_connection_";
  protected final String TEXT_47 = "!=null && conn_param_prefix_";
  protected final String TEXT_48 = "!=null) {" + NL + "                final String prefix_";
  protected final String TEXT_49 = " = config_from_connection_";
  protected final String TEXT_50 = ".keySet().stream()" + NL + "                    .filter(key_";
  protected final String TEXT_51 = " -> key_";
  protected final String TEXT_52 = ".endsWith(\".__version\"))" + NL + "                    .findFirst()" + NL + "                    .map(key_";
  protected final String TEXT_53 = ".substring(0, key_";
  protected final String TEXT_54 = ".lastIndexOf(\".__version\")))" + NL + "                    .orElse(null);" + NL + "                    " + NL + "                if(prefix_";
  protected final String TEXT_55 = "!=null) {" + NL + "                    config_from_connection_";
  protected final String TEXT_56 = ".entrySet().stream().filter(entry_";
  protected final String TEXT_57 = "->entry_";
  protected final String TEXT_58 = ".getKey().startsWith(prefix_";
  protected final String TEXT_59 = ")).forEach(entry_";
  protected final String TEXT_60 = "->{" + NL + "                        configuration_";
  protected final String TEXT_61 = ".put(entry_";
  protected final String TEXT_62 = ".getKey().replaceFirst(prefix_";
  protected final String TEXT_63 = ", conn_param_prefix_";
  protected final String TEXT_64 = "), entry_";
  protected final String TEXT_65 = ".getValue());" + NL + "                    });" + NL + "                }" + NL + "            }";
  protected final String TEXT_66 = NL + NL + "final org.talend.sdk.component.runtime.input.Mapper tempMapper_";
  protected final String TEXT_67 = " = mgr_";
  protected final String TEXT_68 = ".findMapper(\"";
  protected final String TEXT_69 = "\", \"";
  protected final String TEXT_70 = ", configuration_";
  protected final String TEXT_71 = ")" + NL + "    .orElseThrow(() -> new IllegalArgumentException(\"Can't find ";
  protected final String TEXT_72 = "#";
  protected final String TEXT_73 = "\"));" + NL + "" + NL + "org.talend.sdk.component.runtime.di.studio.RuntimeContextInjector.injectLifecycle(tempMapper_";
  protected final String TEXT_74 = ", new org.talend.sdk.component.api.context.RuntimeContextHolder(\"";
  protected final String TEXT_75 = "\", globalMap));" + NL + "" + NL + "final org.talend.sdk.component.runtime.di.studio.ParameterSetter changer_";
  protected final String TEXT_76 = " = new org.talend.sdk.component.runtime.di.studio.ParameterSetter(tempMapper_";
  protected final String TEXT_77 = NL + "    changer_";
  protected final String TEXT_78 = ".change(\"";
  protected final String TEXT_79 = "\", (";
  protected final String TEXT_80 = NL + NL + "final java.util.Map<String, Object> afterVariablesMap_";
  protected final String TEXT_81 = " = org.talend.sdk.component.runtime.di.studio.AfterVariableExtracter.extractAfterVariables(tempMapper_";
  protected final String TEXT_82 = ");" + NL;
  protected final String TEXT_83 = NL + "try {" + NL + "    Object v_";
  protected final String TEXT_84 = " = ((org.talend.sdk.component.runtime.base.Delegated)tempMapper_";
  protected final String TEXT_85 = ").getDelegate();" + NL + "    Object con_";
  protected final String TEXT_86 = " = globalMap.get(\"conn_";
  protected final String TEXT_87 = "\");" + NL + "    if(con_";
  protected final String TEXT_88 = "==null) {" + NL + "        throw new RuntimeException(\"can't find the connection object\");" + NL + "    }" + NL + "" + NL + "    Class<?> current_";
  protected final String TEXT_89 = " = v_";
  protected final String TEXT_90 = ".getClass();" + NL + "    while (current_";
  protected final String TEXT_91 = " != null && current_";
  protected final String TEXT_92 = " != Object.class) {" + NL + "        java.util.stream.Stream.of(current_";
  protected final String TEXT_93 = ".getDeclaredFields()).filter(f_";
  protected final String TEXT_94 = " -> f_";
  protected final String TEXT_95 = ".isAnnotationPresent(org.talend.sdk.component.api.service.connection.Connection.class)).forEach(f_";
  protected final String TEXT_96 = " -> {" + NL + "            if (!f_";
  protected final String TEXT_97 = ".isAccessible()) {" + NL + "                f_";
  protected final String TEXT_98 = ".setAccessible(true);" + NL + "            }" + NL + "            try {" + NL + "                f_";
  protected final String TEXT_99 = ".set(v_";
  protected final String TEXT_100 = ", con_";
  protected final String TEXT_101 = ");" + NL + "            } catch (final IllegalAccessException e_";
  protected final String TEXT_102 = ") {" + NL + "                throw new IllegalStateException(e_";
  protected final String TEXT_103 = ");" + NL + "            }" + NL + "        });" + NL + "        current_";
  protected final String TEXT_104 = " = current_";
  protected final String TEXT_105 = ".getSuperclass();" + NL + "    }" + NL + "} catch (Exception e_";
  protected final String TEXT_106 = ") {" + NL + "    throw e_";
  protected final String TEXT_107 = ";" + NL + "}";
  protected final String TEXT_108 = NL + NL + "int nbLineInput_";
  protected final String TEXT_109 = " = 0;" + NL + "globalMap.put(\"";
  protected final String TEXT_110 = "_NB_LINE\", nbLineInput_";
  protected final String TEXT_111 = ");" + NL + "" + NL + "org.talend.sdk.component.runtime.di.JobStateAware.init(tempMapper_";
  protected final String TEXT_112 = ", globalMap);" + NL + "tempMapper_";
  protected final String TEXT_113 = ".start();" + NL + "final org.talend.sdk.component.runtime.manager.chain.ChainedMapper mapper_";
  protected final String TEXT_114 = ";" + NL + "try {" + NL + "    final java.util.List<org.talend.sdk.component.runtime.input.Mapper> splitMappers_";
  protected final String TEXT_115 = " = tempMapper_";
  protected final String TEXT_116 = ".split(tempMapper_";
  protected final String TEXT_117 = ".assess());" + NL + "    mapper_";
  protected final String TEXT_118 = " = new org.talend.sdk.component.runtime.manager.chain.ChainedMapper(tempMapper_";
  protected final String TEXT_119 = ", splitMappers_";
  protected final String TEXT_120 = ".iterator());" + NL + "    mapper_";
  protected final String TEXT_121 = ".start();" + NL + "    globalMap.put(\"mapper_";
  protected final String TEXT_122 = "\", mapper_";
  protected final String TEXT_123 = ");" + NL + "} finally {" + NL + "    try {" + NL + "        tempMapper_";
  protected final String TEXT_124 = ".stop();" + NL + "    } catch (final RuntimeException re) {" + NL + "        re.printStackTrace();" + NL + "    }" + NL + "}" + NL + "" + NL + "final org.talend.sdk.component.runtime.input.Input input_";
  protected final String TEXT_125 = " = mapper_";
  protected final String TEXT_126 = ".create();" + NL + "input_";
  protected final String TEXT_127 = ".start();" + NL + "globalMap.put(\"input_";
  protected final String TEXT_128 = "\", input_";
  protected final String TEXT_129 = NL + NL + "final javax.json.bind.Jsonb jsonb_";
  protected final String TEXT_130 = " = (javax.json.bind.Jsonb)mgr_";
  protected final String TEXT_131 = ".findPlugin(mapper_";
  protected final String TEXT_132 = ".plugin()).get()" + NL + "                                                     .get(org.talend.sdk.component.runtime.manager.ComponentManager.AllServices.class)" + NL + "                                                     .getServices().get(javax.json.bind.Jsonb.class);" + NL + "" + NL + "final java.util.Map<Class<?>, Object> servicesMapper_";
  protected final String TEXT_133 = ".plugin()).get().get(org.talend.sdk.component.runtime.manager.ComponentManager.AllServices.class).getServices();" + NL + "final javax.json.spi.JsonProvider jsonProvider_";
  protected final String TEXT_134 = " = javax.json.spi.JsonProvider.class.cast(servicesMapper_";
  protected final String TEXT_135 = ".get(javax.json.spi.JsonProvider.class));" + NL + "final javax.json.JsonBuilderFactory jsonBuilderFactory_";
  protected final String TEXT_136 = " = javax.json.JsonBuilderFactory.class.cast(servicesMapper_";
  protected final String TEXT_137 = ".get(javax.json.JsonBuilderFactory.class));" + NL + "final org.talend.sdk.component.api.service.record.RecordBuilderFactory recordBuilderMapper_";
  protected final String TEXT_138 = " = org.talend.sdk.component.api.service.record.RecordBuilderFactory.class.cast(servicesMapper_";
  protected final String TEXT_139 = NL + "                                                                                                                        .get(org.talend.sdk.component.api.service.record.RecordBuilderFactory.class));" + NL + "final org.talend.sdk.component.runtime.record.RecordConverters converters_";
  protected final String TEXT_140 = " = new org.talend.sdk.component.runtime.record.RecordConverters();" + NL + "final Class outputType_";
  protected final String TEXT_141 = " = ";
  protected final String TEXT_142 = ".getClass();" + NL + "" + NL + "Object data_";
  protected final String TEXT_143 = ";" + NL + "while ((data_";
  protected final String TEXT_144 = " = input_";
  protected final String TEXT_145 = ".next()) != null) {" + NL + "    nbLineInput_";
  protected final String TEXT_146 = "++;" + NL + "    globalMap.put(\"";
  protected final String TEXT_147 = ");" + NL + "    final String jsonValueMapper_";
  protected final String TEXT_148 = ";" + NL + "    if (javax.json.JsonValue.class.isInstance(data_";
  protected final String TEXT_149 = ")) {";
  protected final String TEXT_150 = NL + "        ";
  protected final String TEXT_151 = " = jsonb_";
  protected final String TEXT_152 = ".fromJson(javax.json.JsonValue.class.cast(data_";
  protected final String TEXT_153 = ").toString(), ";
  protected final String TEXT_154 = ".getClass());" + NL + "    } else if (org.talend.sdk.component.api.record.Record.class.isInstance(data_";
  protected final String TEXT_155 = ".getClass().cast(converters_";
  protected final String TEXT_156 = ".toType(" + NL + "            registry_";
  protected final String TEXT_157 = "," + NL + "            data_";
  protected final String TEXT_158 = ",";
  protected final String TEXT_159 = NL + "            ";
  protected final String TEXT_160 = ".getClass()," + NL + "            () -> jsonBuilderFactory_";
  protected final String TEXT_161 = "," + NL + "            () -> jsonProvider_";
  protected final String TEXT_162 = "," + NL + "            () -> jsonb_";
  protected final String TEXT_163 = "," + NL + "            () -> recordBuilderMapper_";
  protected final String TEXT_164 = "," + NL + "            registry_metadata_";
  protected final String TEXT_165 = "));" + NL + "    } else {";
  protected final String TEXT_166 = ".fromJson(jsonb_";
  protected final String TEXT_167 = ".toJson(data_";
  protected final String TEXT_168 = "), ";
  protected final String TEXT_169 = ".getClass());" + NL + "    }";
  protected final String TEXT_170 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    /*
  Copyright (C) 2006-2021 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_1);
    
final CodeGeneratorArgument codeGenArgument = CodeGeneratorArgument.class.cast(argument);
final INode node = INode.class.cast(codeGenArgument.getArgument());
if(node == null) {
    throw new IllegalArgumentException("node cannot be null");
}
final String cid = node.getUniqueName();
final String originalName = (String)node.getElementParameter(EParameterName.COMPONENT_NAME.getName()).getValue();
final String family = (String)node.getElementParameter(EParameterName.FAMILY.getName()).getValue();
final String version = (String)node.getElementParameter(EParameterName.VERSION.getName()).getValue();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    /*
  Copyright (C) 2006-2021 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
    final java.util.Map<String, String> configurationToChange = new java.util.HashMap<String, String>();
    
    final List<ElementParameter> params = List.class.cast(node.getElementParametersWithChildrens());
    
    //set the datastore parameters when use existed connection for passing the parameter check like @Required and @Pattern 
    final boolean reuseConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String conn_param_prefix = null;
    java.util.List<String> passwordKeys = new java.util.ArrayList<String>();
    
    if (params != null && !params.isEmpty()) {
        for (final ElementParameter p : params) {
            Object pluginValue = p.getTaggedValue("org.talend.sdk.component.source");
            if(pluginValue == null || !String.class.cast(pluginValue).equalsIgnoreCase("tacokit")) {
                continue;
            }
            try {
                if (!(Boolean) org.talend.core.runtime.IAdditionalInfo.class.cast(p).func("isPersisted")) {
                    continue;
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            //TODO: modify this part for Maps and nested lists.
            if (p.getFieldType() == EParameterFieldType.TABLE || p.getFieldType() == EParameterFieldType.TACOKIT_SUGGESTABLE_TABLE) {
                java.util.List<java.util.Map<String, String>> tableValues = ElementParameterParser.createTableValues((java.util.List<java.util.Map<String, Object>>) p.getValue(), p);
                String[] items = p.getListItemsDisplayCodeName();
                String tableName = p.getName().replace('$', '.');
                boolean primitiveTable = items.length == 1 && items[0].equals(tableName + "[]");
                String tableNamePrefix = tableName + "[]";
                
                java.util.List<String> changable = java.util.List.class.cast(p.getTaggedValue("org.talend.sdk.component.field.changable"));
                
                for (int i = 0; i < tableValues.size(); i++) {
                    java.util.Map<String, String> lineValues = tableValues.get(i);
                    for (int j = 0; j < items.length; j++) {
                        boolean canChange = false;
                        
                        String key = tableName + "[" + i + "]";
                        if (!primitiveTable) {
                            final String columnName = items[j].substring(tableNamePrefix.length(), items[j].length());
                            key = key + columnName;
                            
                            if(changable!=null && changable.contains(items[j])) {
                                canChange = true;
                            }
                        }
                        String value = lineValues.get(items[j]);
                        
                        if(canChange) {
                            configurationToChange.put(key, value);
                        }
                        
                        if (!org.talend.core.model.utils.ContextParameterUtils.isDynamic(value)) {
                            if (org.talend.core.model.utils.TalendTextUtils.isEnclosed(value)) {
                                value = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                            }
                            value = org.talend.core.model.utils.TalendTextUtils.addQuotes(value);
                        }

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_13);
    
                    }
                }
            } else if (p.getFieldType() == EParameterFieldType.SCHEMA_TYPE || p.getFieldType() == EParameterFieldType.TACOKIT_INPUT_SCHEMA) {
                final String parameterName = p.getName();
                IConnection connection = null;
                final List<? extends IConnection> connections;
                if (p.getFieldType() == EParameterFieldType.SCHEMA_TYPE) {
                    connections = NodeUtil.getOutgoingConnections(node, p.getContext());
                } else {
                    //TODO may remove this and EParameterFieldType.TACOKIT_INPUT_SCHEMA support
                    connections = NodeUtil.getIncomingConnections(node, p.getContext());
                }
                
                IMetadataTable metaTable = null;
                if(connections != null && !connections.isEmpty()) {
                    connection = connections.get(0);
                    metaTable = (connection!=null) ? connection.getMetadataTable() : null;
                } else if("FLOW".equals(p.getContext())) {
                    //pass the connector schema when no output line case
                    //for example: tfixedflowinput==>tjdbcoutput, we need the column key/db column name info in studio design schema
                    List<IMetadataTable> metadataTables = node.getMetadataList();
                    if(metadataTables!=null && !metadataTables.isEmpty()) {
                        metaTable = metadataTables.get(0);
                    }
                }
                
                if(metaTable != null) {
                    List<IMetadataColumn> columns = metaTable.getListColumns();
                    boolean hasDynamic = false;
                    for (int i = 0; i < columns.size(); i++) {
                        IMetadataColumn col = columns.get(i);
                        if ("id_Dynamic".equals(col.getTalendType())) {
                            hasDynamic = true;
                            int length = col.getLength() == null ? -1 : col.getLength();
                            int precision = col.getPrecision() == null ? -1 : col.getPrecision();
                            String pattern = col.getPattern() == null ? "" : col.getPattern();
                        
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(length);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(precision);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(org.talend.core.model.utils.TalendTextUtils.removeQuotes(pattern));
    stringBuffer.append(TEXT_19);
    
                        }
                    }
                    
                    String [] columnMetas = java.util.Optional.ofNullable(p.getListItemsDisplayCodeName()).orElse(new String[0]);
                    List<String> metas = new java.util.ArrayList();
                    for (String k : columnMetas){
                        metas.add(k.substring(k.lastIndexOf(".")+1));
                    }
                    
                    final boolean isFullSchema = metas.contains("talendType");
                    
                    if (isFullSchema || !hasDynamic){
                        for(int i = 0; i < columns.size(); i++) {
                            IMetadataColumn column = columns.get(i);
                            for (String meta : metas){
                                if (meta.equals("label")){
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("originalDbColumnName")){
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("pattern")){
                                String pattern = column.getPattern() == null ? "" : column.getPattern();
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(org.talend.core.model.utils.TalendTextUtils.removeQuotes(pattern));
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("defaultValue")){
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getDefault());
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("key")){
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.isKey());
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("nullable")){
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.isNullable());
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("talendType")){
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getTalendType());
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("type")){
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getType());
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("length")){
                                int length = column.getLength() == null ? -1 : column.getLength();
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(length);
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("precision")){
                                int precision = column.getPrecision() == null ? -1 : column.getPrecision();
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(precision);
    stringBuffer.append(TEXT_19);
    
                                }
                                if (meta.equals("comment")){
                                
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getComment());
    stringBuffer.append(TEXT_19);
    
                                }
                            }
                            if (metas.size() == 0){
                            
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    
                            }
                        }
                    }
                }
            } else {
                final String key;
                if(!p.getName().contains("$")){
                    key = p.getName();
                }else{
                    final StringBuilder keyBuilder = new StringBuilder();
                    for (String part : p.getName().split("\\.")) {
                        if (keyBuilder.length() != 0) {
                            keyBuilder.append(".");
                        }
                        if (part.contains("$") && !part.startsWith("$")) {
                            keyBuilder.append(part.replace("$", "."));
                        } else {
                            keyBuilder.append(part);
                        }
                    }
                    key = keyBuilder.toString();
                }
                // Do not put in configuration hidden parameters
                if (!p.isShow(params) && !key.endsWith("__version")) {
                
    stringBuffer.append(TEXT_35);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_36);
    
                    continue;
                }
                String value = null;
                if(p.getFieldType() == EParameterFieldType.PASSWORD) {
                    value = ElementParameterParser.getPasswordValue(node, p.getVariableName());
                    if (value == null || value.trim().isEmpty()) {
                        value = null;
                    } else {
                        passwordKeys.add(key);
                    }
                } else {
                    value = ElementParameterParser.getStringElementParameterValue(p);
                    // fix MEMO Types: behave now as TEXT_AREA
                    if (p.getFieldType().toString().startsWith("MEMO")){
                        value = value.replace("\n", " ").replace("\r", " ");
                    }
                    if (org.talend.core.model.utils.ContextParameterUtils.isDynamic(value)) {
                        value = "String.valueOf(" + value + ")";
                    }
                    else {
                        if (org.talend.core.model.utils.TalendTextUtils.isEnclosed(value)) {
                            value = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                        }
                        
                        Object sourceName = p.getTaggedValue("org.talend.sdk.component.source");
                        boolean isTacokit = "tacokit".equalsIgnoreCase(String.valueOf(sourceName));
                        if(isTacokit) {
                        	value = org.talend.core.model.utils.TalendTextUtils.addQuotes(org.talend.core.utils.TalendQuoteUtils.checkAndAddBackslashes(value));
                        } else {
                        	value = org.talend.core.model.utils.TalendTextUtils.addQuotes(value);
                        }
                        
                    }
                }
                if (value != null) {
                 if(key.endsWith("$maxBatchSize")){
                  
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_39);
    
                 } else if(p.getFieldType() == EParameterFieldType.CLOSED_LIST) {
                   String valueTemp = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                    if ("".equals(valueTemp)) {
                       String[] listItemsDisplayCodeValue = p.getListItemsDisplayCodeName();
                       if(listItemsDisplayCodeValue != null && listItemsDisplayCodeValue.length > 0){
                          valueTemp = listItemsDisplayCodeValue[0];
                          value = org.talend.core.model.utils.TalendTextUtils.addQuotes(valueTemp);
                       }
                    }
                }
                
                //need to get the common prefix for datastore
                if (reuseConnection && key.matches("\\w+\\.\\w+\\.\\w+\\.__version") && !p.isShow(params)) {
                    conn_param_prefix = key.substring(0, key.lastIndexOf(".__version"));
                }

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_13);
    
                } // else do not put value in configuration
            }
        }
        String datastorePath = ElementParameterParser.getValue(node,"__DATASTORE_PATH__");
        if (reuseConnection && datastorePath != null && !datastorePath.isEmpty()) {
            conn_param_prefix = datastorePath;
        }

        if (reuseConnection && conn_param_prefix!=null) {
            final String connectionKey = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn_param_prefix);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
        }
    }

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(family);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(originalName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(family);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(originalName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
for(java.util.Map.Entry<String, String> entry : configurationToChange.entrySet()) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_39);
    
}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
boolean useExistedConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
if(useExistedConnection) {//}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
//{
}

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
final List<? extends IConnection> connections = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
if (connections.isEmpty()) {
    throw new RuntimeException("Missing output connection for component " + family + "#" + originalName);
}
final String output = connections.iterator().next().getName();

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(output);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(output);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(output);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(output);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(output);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(output);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(output);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(output);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    return stringBuffer.toString();
  }
}
