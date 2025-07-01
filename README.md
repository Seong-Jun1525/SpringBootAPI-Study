# SpringBootAPI-Study

## Controller

- @Controller은 @Component 를 구체화한 것으로 해당 클래스를 Bean으로 등록하여 Controller로 사용한다는 것을 알린다.

### 종류

- `@Controller`
  - View를 반환
- `@RestController`
  - @Controller + @RequestBody
  - JSON 객체를 반환

### RequestMapping

- 들어온 요청을 특정 메서드와 매핑하기 위해 사용하는 어노테이션

- `value` : 요청 받을 URL
- `method` : 어떤 요청으로 받을지 정의 (HTTP Method)

## GET API

### 예전 방식

```java
@RequestMapping(path = "/hi", method = RequestMethod.GET)
// === http://localhost:포트번호/api/get/hi
public String hi() {
  return "hi";
}
```

### @GetMapping 사용

#### PathVariable

- 어노테이션을 사용 하여 요청 URI 매핑에서 템플릿 변수를 처리

```java
// http://localhost:포트번호/api/get/path-variable/{name}
@GetMapping("/path-variable/{name}")
public String pathVariable(@PathVariable(name = "name") String name) {
  System.out.println("@PathVariable : " + name);
  return name;
}
```

#### Query Parameter

- Map 사용

  ```java
  // http://localhost:포트번호/api/get/query-param?user=steve&email=test@test.com&age=26
    // Map 으로 받을 경우 무엇을 받을지 모름 => 직관적이지 않음
  @GetMapping(path = "query-param")
  public String queryParam(@RequestParam Map<String, String> queryParam) {

    StringBuilder sb = new StringBuilder();

    queryParam.entrySet().forEach(entry -> {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue() + "\n");

      sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
    });

    return sb.toString();
  }
  ```

- RequestParam 사용

  ```java
  @GetMapping("query-param02")
  public String queryParam02(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
    System.out.println(name);
    System.out.println(email);
    System.out.println(age);

    return name + " " + email + " " + age;
  }
  ```

  - Map 으로 받는 것보다 더 직관적임
  - _하지만 이렇게 하는것도 넘겨받을 값이 많아 질 경우 @RequestParam을 계속 붙여야하므로 불편함_
  - `DTO(Data Transfer Object)`를 만들어서 매핑해준다

- DTO 사용하기

  ```java
  @GetMapping("query-param03")
  public String queryParam03(UserRequestDTO userRequestDTO) {
    System.out.println(userRequestDTO.getName());
    System.out.println(userRequestDTO.getEmail());
    System.out.println(userRequestDTO.getAge());

    return userRequestDTO.toString();
  }
  ```

- @RequestParam을 붙이지 않아도 스프링부트에서 판단한다
- 객체의 변수와 이름을 매칭한다
