n = int(input())
arr = [[0 for _ in range(n)] for _ in range(n)]
i = 1
for r in range(n):
    for c in range(n):
        arr[c][r] = i
        i += 1

for row in arr:
    print(*row)