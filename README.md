# CopenhagenTransit

A Java console application that calculates travel fares for multiple transport types across zones in Copenhagen, complete with a formatted receipt output.

---

## Description

CopenhagenTransit accepts user input for transport type, zone number, and passenger class, then looks up the correct fare from a built-in pricing table and prints a formatted receipt including tax and total.

---

## Features

- **5 transport types** — Bus, Train, Airplane, Helicopter, Boat
- **5 fare zones** — Zone 1 through Zone 5
- **2 passenger types** — Adult and Child
- **Input validation** — loops until valid input is entered for all fields
- **Formatted receipt** — includes date, time, base fare, 25% tax, and total
- **2D array fare tables** — clean and easy to update

---

## Sample Output

```
╔══════════════════════════════════════════╗
║	COPENHAGEN TRANSIT AUTHORITY	       ║
║	Date: June 4, 2026    Time: 14:35    ║
╠══════════════════════════════════════════╣
║  Transport  :  AIRPLANE                  ║
║  Zone       :  3                         ║
║  Passenger  :  ADULT                     ║
╠══════════════════════════════════════════╣
║  BASE FARE  :  USD               560.00  ║
║  TAX (25%)  :  USD               140.00  ║
╠══════════════════════════════════════════╣
║  TOTAL      :  USD               700.00  ║
╚══════════════════════════════════════════╝
      Thank you for travelling with us!
```

---

## Files

| File | Description |
|------|-------------|
| `CopenhagenTransit.java` | Main class — fare tables, input methods, validation, receipt |
| `RunClassMethod.java` | Driver class — creates an instance and runs the program |
| `KuzeDriver.java` | Driver class (replacement) — creates an instance and runs the program |

---

## How to Run

**Compile:**
```bash
javac CopenhagenTransit.java RunClassMethod.java
```

**Run:**
```bash
java RunClassMethod
```

---

## Fare Tables

### Bus & Train
| Zone | Bus Adult | Bus Child | Train Adult | Train Child |
|------|-----------|-----------|-------------|-------------|
| 1    | 23.00     | 11.50     | 28.00       |   14.00     |
| 2 | 23.00 | 11.50 | 35.00 | 17.50 |
| 3 | 34.50 | 23.00 | 49.00 | 24.50 |
| 4 | 46.00 | 23.00 | 63.00 | 31.50 |
| 5 | 57.50 | 28.50 | 77.00 | 38.50 |

### Airplane & Helicopter
| Zone | Airplane Adult | Airplane Child | Helicopter Adult | Helicopter Child |
|------|----------------|----------------|------------------|------------------|
| 1 | 350.00 | 175.00 | 850.00 | 425.00 |
| 2 | 420.00 | 210.00 | 1020.00 | 510.00 |
| 3 | 560.00 | 280.00 | 1360.00 | 680.50 |
| 4 | 700.00 | 350.00 | 1700.00 | 850.50 |
| 5 | 840.00 | 420.00 | 2040.00 | 1020.50 |

### Boat
| Zone | Adult | Child |
|------|-------|-------|
| 1 | 45.00 | 22.50 |
| 2 | 60.00 | 30.00 |
| 3 | 80.00 | 40.00 |
| 4 | 100.00 | 50.00 |
| 5 | 120.00 | 60.00 |

---

## Requirements

- Java 14 or higher (uses switch expressions with `->` arrow syntax)
- No external libraries — standard Java only

---

## Author

**Tye Tosh**

---

## Future Plans

- Load fare tables from a database
- Add return journey pricing
- Add multi-zone journey support
- GUI interface
