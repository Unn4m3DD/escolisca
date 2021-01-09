#!/usr/bin/env python
import struct
import datetime
import sys
import signal
import socket
import psutil
import time
print()


def signal_handler(sig, frame):
  print('\nDone!')
  sys.exit(0)


signal.signal(signal.SIGINT, signal_handler)
print('Press Ctrl+C to exit...')

ip_addr = "0.0.0.0"
tcp_port = 1111

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

sock.connect((ip_addr, tcp_port))

while True:
  try:
    pkt = struct.pack('dd', psutil.cpu_percent(interval=.01), psutil.virtual_memory().percent)
    sock.send(pkt)
    time.sleep(1)
  except (socket.timeout, socket.error):
    print('Server error. Done!')
    sys.exit(0)
