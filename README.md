#### 1. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.

* ContextLoaderListener 로딩 (@WebListener)
* ContextLoaderListener.contextInitialized() 호출
* DispatcherServlet 로딩 (@WebServlet(name = "dispatcher", urlPatterns = {"", "/"}, loadOnStartup = 1))
* DispatcherServlet.init() 호출
* DispatcherServlet.service() 대기
* ContextLoaderListener.contextDestroyed() 호출 

---

* 쓰인 어노테이션의 종류는 4가지

```java
@FunctionalInterface
RowMapper.java
// 각 dao에서 구현하도록 되어있는 인터페이스에 쓰이지만, 현재 무슨용도인지 파악 안됨.
  
@WebServlet(name = "dispatcher", urlPatterns = {"", "/"}, loadOnStartup = 1)
DispatcherServlet.java  
// javax.servlet.http.HttpServlet 구현체
// org.springframework.web.servlet.DispatcherServlet과 동일 역할로 추정 // in web.xml
  
@WebFilter("/*")
ResourceFilter.java  
// 필터
  
@WebListener
ContextLoaderListener.java
// javax.servlet.ServletContextListener 구현체
// org.springframework.web.context.ContextLoaderListener과 동일 역할로 추정 // in web.xml

```

#### 2. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.

* ResourceFilter.doFilter() 호출
* DispatcherServlet.service() 호출
* RequestMapping 에서 컨트롤러 탐색 // mappings.put("/", new HomeController());
* JspView 모델 & 뷰 할당
* index.jsp 로 포워드

#### 7. next.web.qna package의 ShowController는 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.

* 