import socket
import threading
import signal
import sys
import struct


def signal_handler(sig, frame):
  print('\nDone!')
  sys.exit(0)


signal.signal(signal.SIGINT, signal_handler)
print('Press Ctrl+C to exit...')

##


def handle_client_connection(client_socket, address):
  message_format = 'dd'
  try:
    while True:
      request = client_socket.recv(struct.calcsize(message_format))
      pktheader = struct.unpack(message_format, request)
      cpu, memory = pktheader
      print(f"cpu usage: {cpu}, memory usage: {memory}")
  except (socket.timeout, socket.error):
    print('Client {} error. Done!'.format(address))
  finally:
    client_socket.close()


ip_addr = "0.0.0.0"
tcp_port = 1111


server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((ip_addr, tcp_port))
server.listen(5)  # max backlog of connections

print('Listening on {}:{}'.format(ip_addr, tcp_port))

while True:
  client_sock, address = server.accept()
  client_handler = threading.Thread(
      target=handle_client_connection, args=(client_sock, address), daemon=True)
  client_handler.start()
