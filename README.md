# SpringBootAPI-Study

## Controller

- @Controller은 @Component 를 구체화한 것으로 해당 클래스를 Bean으로 등록하여 Controller로 사용한다는 것을 알린다.

### 종류

- `@Controller`
  - View를 반환
- `@RestController`
  - @Controller + @ResponseBody
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

---

## POST API

### @PostMapping 사용

```java
@PostMapping("/post")
public void post(@RequestBody Map<String, Object> requestData) {
  requestData.entrySet().forEach(entry -> {
    System.out.println("key : " + entry.getKey());
    System.out.println("value : " + entry.getValue());
  });
}

@PostMapping("/post2")
public void post2(@RequestBody PostRequestDTO postRequestDTO) {
  System.out.println(postRequestDTO.toString());
}
```

### @JsonProperty

- 키값을 매칭시킬 수 있다.
- 하나하나 전부 작성해줘야 하는 단점이 있다.
- Camel Case, Snake Case 등의 특정 표기법이 아니거나 `약어` 같은 경우에 사용한다

```java
// ...
private String account;
private String email;
private String address;
private String password;

@JsonProperty("phone_number")
private String phoneNumber;
// ...
```

## PUT API

- 새로운 리소스를 생성하거나 대상 리소스를 나타내는 데이터를 대체한다
- PUT과 POST의 차이는 멱등성이다
- PUT은 멱등성을 갖는다
- PUT은 한 번을 보내도, 여러 번을 연속으로 보내도 같은 효과를 보인다

#### 멱등성

> _어떤 연산을 여러 번 반복해도 처음 연산과 동일한 결과를 얻는 성질을 의미_

```java
@PutMapping("/put/{userId}")
public PutRequestDTO putTest(@RequestBody PutRequestDTO putRequestDTO, @PathVariable(name = "userId") Long id) {
  System.out.println(putRequestDTO.toString());
  System.out.println("id : " + id);

  return putRequestDTO;
}
```

- RestController인 경우 Object 자체를 반환하면
- 스프링부트 자체에서 Object 를 Object Mapper 를 통해서 JSON으로 변환해줌

### @JsonNaming

- 해당 클래스의 표기법 지정 어노테이션

- SnakeCase로 표기법 지정

  ```java
  @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
  public class PutRequestDTO {
    private String name;
    private int age;
    private List<CarDTO> carList;

    // ...
  ```

## DELETE API

- 삭제된 데이터든 삭제하는 데이터든 삭제하는 것은 동일하므로 멱등성을 갖는다
- 삭제한 순간 데이터는 삭제되므로 안정성은 없다
- Delete Method 는 많은 데이터를 받지 않는다 (받을 필요가 없음)

```java
@DeleteMapping("/delete/{userId}")
public void deleteTest(@PathVariable("userId") String userId, @RequestParam(value = "account") String account) {
    System.out.println(userId);
    System.out.println(account);
}

/** 오류발생
  java.lang.IllegalArgumentException:
  Name for argument of type [java.lang.String] not specified, and parameter name information not available via reflection.
  Ensure that the compiler uses the '-parameters' flag.

  => @PathVariable("userId") 로 userId 명시로 해결!!
*/
```

- Delete -> 자체가 리소스 삭제
  - 그렇기 때문에 리소스가 없는 상태이더라도 200 상태코드 반환 => 멱등성!
