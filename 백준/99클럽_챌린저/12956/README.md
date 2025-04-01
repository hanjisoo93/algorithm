https://www.acmicpc.net/problem/12956

## 1. 플로이드 워셜 알고리즘(Floyd-Warshall Algorithm)
- 모든 정점 쌍(i, j)에 대한 최단 거리를 구하는 알고리즘
- 동일한 도로가 여러 번 주어졌을 경우 min() 처리 필요
- 최단 거리뿐 아니라 경로 추적까지 응용 가능
## 2. 그래프 복사 / 깊은 복사(Deep Copy of 2D Arrays)
- int[][] arr 은 참조 타입
- clone() vs deep copy 차이 이해
- 복사를 잘못하면 원본 데이터가 오염되어 후속 계산 결과가 틀어짐
- 즉, 불변성 보장을 위한 복사 개념 학습