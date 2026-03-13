# Page Replacement Algorithms Simulation

A Java implementation and comparison of several **page replacement algorithms** used in operating systems memory management.

The program simulates how different algorithms handle page faults when managing a limited number of memory frames.

This project was created as part of a **Operating Systems course**.

---

## Implemented Algorithms

The following page replacement algorithms are implemented:

- **FIFO** – First In First Out
- **LRU** – Least Recently Used
- **OPT** – Optimal Page Replacement
- **RAND** – Random Replacement
- **Second Chance** – Clock / Second Chance algorithm

Each algorithm determines which memory page should be replaced when a page fault occurs.

---

## Project Structure

src/
│
├── PageReplacementAlgorithm.java # abstract base class
├── Simulation.java # program entry point
│
├── FIFO.java # FIFO algorithm
├── LRU.java # LRU algorithm
├── OPT.java # Optimal algorithm
├── RAND.java # Random replacement
└── SecondChance.java # Second Chance algorithm

---

## Features

- Simulation of multiple page replacement strategies
- Comparison of algorithm behavior
- Page fault counting
- Object-oriented implementation
- Clear separation of algorithms and simulation logic

---

## Technologies

- **Java**
- Standard Java libraries

---

## Running the Program

1. Compile the project:
javac src/*.java

2. Run the simulation:
java -cp src Simulation

---

## Learning Objectives

This project demonstrates:

- memory management concepts in operating systems
- page replacement strategies
- algorithm comparison
- object-oriented design in Java
- simulation of system behavior

---

## Author

Created as a university project for a **Operating Systems course**.
