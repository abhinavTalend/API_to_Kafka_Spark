package org.talend.designer.codegen.translators.generic.component;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class ComponentFinally
{
  protected static String nl;
  public static synchronized ComponentFinally create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentFinally result = new ComponentFinally();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "final org.talend.sdk.component.runtime.input.Mapper mapper_";
  protected final String TEXT_2 = " = org.talend.sdk.component.runtime.input.Mapper.class.cast(globalMap.remove(\"mapper_";
  protected final String TEXT_3 = "\"));" + NL + "final org.talend.sdk.component.runtime.input.Input input_";
  protected final String TEXT_4 = " = org.talend.sdk.component.runtime.input.Input.class.cast(globalMap.remove(\"input_";
  protected final String TEXT_5 = "\"));" + NL + "" + NL + "boolean swallowNextException_";
  protected final String TEXT_6 = " = false;" + NL + "try {" + NL + "    if (input_";
  protected final String TEXT_7 = " != null) {" + NL + "        input_";
  protected final String TEXT_8 = ".stop();" + NL + "    }" + NL + "} catch (final RuntimeException re) {" + NL + "    swallowNextException_";
  protected final String TEXT_9 = " = true;" + NL + "    throw new TalendException(re, currentComponent, cLabel, globalMap);" + NL + "} finally {" + NL + "    try {" + NL + "        if (mapper_";
  protected final String TEXT_10 = " != null) {" + NL + "            mapper_";
  protected final String TEXT_11 = ".stop();" + NL + "        }" + NL + "    } catch (final RuntimeException re) {" + NL + "        if (!swallowNextException_";
  protected final String TEXT_12 = ") {" + NL + "            throw new TalendException(re, currentComponent, cLabel, globalMap);" + NL + "        }" + NL + "    }" + NL + "}";

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
    
final CodeGeneratorArgument codeGenArgument = CodeGeneratorArgument.class.cast(argument);
final INode node = INode.class.cast(codeGenArgument.getArgument());
final String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
