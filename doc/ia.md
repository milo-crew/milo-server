# IA (Information Architecture)

## Scenarios

### 001. 사용자 생성

```json
{
  "success": true,
  "error": null,
  "results": {
    "uuid": "123e4567-e89b-12d3-a456-426614",
    "createdAt": "2023-10-01T12:00:00Z"
  }
}
```

### 002. 테마를 조회한다

```json
{
  "success": true,
  "error": null,
  "results": {
    "themes": [
      {
        "uuid": "de305d54-75b4-431b-adb2-eb6b9e546014",
        "category": "theme",
        "themeName": "방탈출",
        "userCount": 1000,
        "createdAt": "2023-10-01T12:00:00Z"
      }
    ],
    "themeCount": 10
  }
}
```

```json
{
  "success": false,
  "error": {
    "code": 1000,
    "reason": "존재하지 않는 엔드포인트입니다."
  },
  "results": null
}
```

### 003. 스토리를 조회한다

```json
{
  "success": true,
  "error": null,
  "results": {
    "stories": [
      {
        "uuid": "de305d54-75b4-431b-adb2-eb6b9e546014",
        "category": "story",
        "themeName": "무인도에서 살아남기",
        "themeEngName": "survival_on_an_island",
        "userCount": 200,
        "createdAt": "2023-10-01T12:00:00Z"
      }
    ],
    "storyCount": 10
  }
}
```

### 004. 스토리 진행

```json
{
  "uuids": {
    "user": "de305d54-75b4-431b-adb2-eb6b9e546014",
    "theme": "de305d54-75b4-431b-adb2-eb6b9e546014",
    "story": "de305d54-75b4-431b-adb2-eb6b9e546014"
  }
}
```
```json
{
  "success": true,
  "error": null,
  "results": {
    "title": "무인도에서 깨어나다",
    "content": "당신은 무인도에서 깨어났습니다. 주변에는 아무도 없습니다. 당신은 어떻게 할까요?",
    "choices": [
      {
        "choiceUuid": "ds305d54-75b4-431b-adb2-eb6b9e546014", 
        "text": "주변을 탐색한다",
        "createdAt": "2023-10-01T12:00:00Z"
      }
    ]
  }
}
```

### 005. 다음 스토리 진행

path: /stories/ds305d54-75b4-431b-adb2-eb6b9e546014/next

```json
{
  "uuids": {
    "user": "de305d54-75b4-431b-adb2-eb6b9e546014", 
    "story": "de305d54-75b4-431b-adb2-eb6b9e546014",
    
  }
}
```
```json
{
  "success": true,
  "error": null,
  "results": {
    "title": "무인도에서 깨어나다",
    "content": "당신은 무인도에서 깨어났습니다. 주변에는 아무도 없습니다. 당신은 어떻게 할까요?",
    "choices": [
      {
        "choiceUuid": "ds305d54-75b4-431b-adb2-eb6b9e546014", 
        "text": "주변을 탐색한다",
        "createdAt": "2023-10-01T12:00:00Z"
      }
    ]
  }
}
```

### 006. 엔딩 보기

- http -> streaming 방식으로 변경 제안 

```json
{
  "uuids": {
    "user": "de305d54-75b4-431b-adb2-eb6b9e546014", 
    "story": "de305d54-75b4-431b-adb2-eb6b9e546014",
  }
}
```
```json
{
  "success": true,
  "error": null,
  "results": {
    "endingAt": "2023-10-01T12:00:00Z",
    "title": "도망친 곳에 낙원은 없었다",
    "content": "당신은 무인도에서 살아남기 위해 최선을 다했지만, 결국 낙원은 없었습니다."
  }
}
```