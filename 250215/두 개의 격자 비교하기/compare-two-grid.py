n,m = map(int, input().split())

arr1 = [list(map(int, input().split())) for _ in range(n)]
arr2 = [list(map(int, input().split())) for _ in range(n)]
ans = [[1 for _ in range(m)] for _ in range(n)]
for r in range(n):
    for c in range(m):
        if arr1[r][c] == arr2[r][c]:
            ans[r][c] = 0

for row in ans:
    print(*row)