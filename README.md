# Restaurant Ordering System

A Java-based restaurant ordering application with a tree-structured menu, drink vending machine, and order queue management system.

## Project Overview

This application provides an interactive console-based restaurant ordering system featuring:
- Tree-based menu navigation (Appetizers, Salads, Burgers, Pizzas, Desserts)
- Drink vending machine with stack-based inventory (Juice, Water, Cola)
- Order queue management with add, view, delete, and execute operations

## Developers

- Turki Almufarrej
- Mohammed Ababotain
- Turki Alshaalan
- Omar Alshuger

## Project Structure

```
LabFinalProject/
├── src/
│   ├── main.java                 # Main application entry point
│   ├── drink_vending_machine.java # Drink vending machine implementation
│   ├── Tree.java                 # Tree data structure
│   ├── TreeNode.java             # Tree node implementation
│   ├── Item.java                 # Item class for menu items
│   ├── CreatOBJ.java             # Menu object creator
│   ├── LinkedQueue.java          # Linked queue implementation
│   ├── LinkedStack.java          # Linked stack implementation
│   ├── SinglyLinkedList.java     # Singly linked list
│   └── Node.java                 # Node class
├── Drinks.txt                    # Drink inventory data
├── Items.txt                     # Menu items data
└── bin/                          # Compiled Java classes
```

## Features

### Menu System
- **Appetizers**: French Fries, Onion Rings, Mozzarella Sticks, Chicken Wings, Nachos
- **Salads**: Caesar Salad, Greek Salad, Caprese Salad, Cobb Salad, Garden Salad
- **Burgers**: 
  - Fried Burgers: Cheeseburger, Hamburger
  - Grilled Burgers: Veggie Burger, Mushroom Swiss Burger, BBQ Chicken Burger
- **Pizzas**: Cheese Pizza, Pepperoni Pizza, Margherita Pizza, BBQ Chicken Pizza, Veggie Pizza
- **Desserts**: Chocolate Cake, Apple Pie, Ice Cream Sundae, Brownie Sundae, Cheesecake

### Drink Vending Machine
- Juice (ID: 1)
- Water (ID: 2)
- Cola (ID: 3)

### Order Management
1. Order from Menu - Add items to current order
2. View Order - Display current order
3. View Line of Orders - Process pending orders
4. Delete Item - Remove specific item from order
5. Delete Order - Remove entire order by ID
6. Order from Vending Machine - Add drinks to order

### Special Commands
- `-1`: Exit the restaurant
- `-2`: Close and finalize the current order
- `-3`: Display remaining stock for all items

## Data Format

### Items.txt Format
```
CategoryName
ID Name Price Quantity
```

### Drinks.txt Format
```
ID Type Quantity Price
```

## How to Run

1. Compile the project:
   ```bash
   javac -d bin src/*.java
   ```

2. Run the application:
   ```bash
   java -cp bin main
   ```

3. Follow the on-screen menu to place orders

## Technology Stack

- **Language**: Java
- **Data Structures**: Tree, LinkedList, Stack, Queue
- **Input/Output**: File I/O for menu and inventory data

## Architecture

The application uses several custom data structures:
- **Tree**: Manages hierarchical menu structure
- **LinkedQueue**: Manages order queue (FIFO)
- **LinkedStack**: Manages drink inventory (LIFO)
- **SinglyLinkedList**: General-purpose linked list

Each data structure is implemented from scratch to demonstrate understanding of fundamental data structure concepts.