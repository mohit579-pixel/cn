import socket


def ip_to_url(ip_address):
    try:
        url = socket.gethostbyaddr(ip_address)
        return url[0]
    except socket.error:
        return "Could not resolve the IP address to a URL"
def url_to_ip(url):
    try:
        ip_address = socket.gethostbyname(url)
        return ip_address
    except socket.error:
        return "Could not resolve the URL to an IP address"

while True:
    print("DNS Lookup Program")
    print("1. IP to URL")
    print("2. URL to IP")
    print("3. Exit")
    choice = input("Enter your choice (1/2/3): ")
    if choice == '1':
        ip_address = input("Enter the IP address: ")
        url = ip_to_url(ip_address)
        print(f"URL for IP address {ip_address}: {url}")
    elif choice == '2':
        url = input("Enter the URL: ")
        ip_address = url_to_ip(url)
        print(f"IP address for URL {url}: {ip_address}")
    elif choice == '3':
        break
    else:
        print("Invalid choice. Please enter 1, 2, or 3.")