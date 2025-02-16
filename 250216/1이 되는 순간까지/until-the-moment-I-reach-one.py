N = int(input())

# Write your code here!
def f(n, ans):
    if n == 1:
        print(ans)
        return
    elif n % 2 == 0:
        ans += 1
        return f(n//2, ans)
    elif n % 2 == 1:
        ans += 1
        return f(n//3, ans)

f(N,0)