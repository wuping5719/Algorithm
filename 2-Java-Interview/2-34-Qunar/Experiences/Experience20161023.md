### 2016年10月23日 去哪儿网秋招, 北京, Java后台研发面经 ###

<Strong>技术面</Strong>

* 1. Java自定义注解的使用？   

 注解(Annotation)自定义注解入门: <http://www.cnblogs.com/peida/archive/2013/04/24/3036689.html>    
  1) 元注解的作用就是负责注解其他注解。Java5.0定义了4个标准的meta-annotation类型，它们被用来提供对其它annotation类型作说明。   
  Java5.0定义的元注解：   
   (1) @Target,   
   (2) @Retention,  
   (3) @Documented,   
   (4) @Inherited.    
   这些类型和它们所支持的类在java.lang.annotation包中可以找到。  
  2)示例：   
```java
  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  public @interface Column {
     public String name() default "fieldName";
     public String setFuncName() default "setField";
     public String getFuncName() default "getField"; 
     public boolean defaultDBValue() default false;
  }
```
