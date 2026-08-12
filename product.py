class Product:
    def __init__(self, name, price, quantity):
        self.name = name
        self.price = price
        self.quantity = quantity

    def total_price(self):
        return self.price * self.quantity

    def show(self):
        print(f"Name: {self.name}")
        print(f"Price: {self.price}")
        print(f"Quantity: {self.quantity}")
        print(f"Total: {self.total_price()}")


if __name__ == "__main__":
    p1 = Product("Notebook", 50, 3)
    p1.show()