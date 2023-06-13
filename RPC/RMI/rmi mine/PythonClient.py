import socket

HOST = 'localhost'
PORT = 5555

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    s.sendall(str.encode('Hello, world'))
    data = s.recv(1024)

print('Received from server:', data.decode())
