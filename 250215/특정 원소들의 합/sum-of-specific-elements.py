ans = 0

arr_2d = []
for _ in range(4):
    arr_1d = list(map(int, input().split()))
    arr_2d.append(arr_1d)

for i in range(4):
    for j in range(4):
        if i >= j:
            ans += arr_2d[i][j]

print(ans)