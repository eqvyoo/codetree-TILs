arr = ["apple", "banana", "grape", "blueberry", "orange"]
target = input()
ans = 0
for str in arr:
    if str[2] == target or str[3] == target:
        ans += 1
        print(str)
print(ans)
