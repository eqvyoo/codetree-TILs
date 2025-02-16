N = int(input())

# Write your code here!
def f(n):
    if n < 10:
        return n*n
    else:
        return f(n//10) + ((n%10)**2)

print(f(N))