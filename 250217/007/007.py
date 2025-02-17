

# Write your code here!
class Code:
    def __init__(self, secret_code, meeting_point, time):
        self.secret_code = secret_code
        self.meeting_point = meeting_point
        self.time = time


secret_code, meeting_point, time = input().split()
time = int(time)
code1 = Code(secret_code, meeting_point, time)
print("secret code :", code1.secret_code)
print("meeting point :", code1.meeting_point)
print("time :", code1.time)