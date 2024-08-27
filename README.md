# Hospital Management System (HMS)

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Database Setup](#database-setup)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The Hospital Management System (HMS) is a desktop-based Java application designed to manage the day-to-day operations of a hospital. This application helps in managing patient information, employee details, room allocation, and other hospital-related functions efficiently. It is built using Java Swing for the user interface and MySQL for database management.

## Features
- User authentication (login functionality)
- Add and update patient information
- Manage employee details
- Allocate and search rooms
- Display department and ambulance information
- Check patient discharge status
- Interactive GUI with modern design elements

## Technologies Used
- **Java**: Core programming language
- **Java Swing**: For building the graphical user interface (GUI)
- **MySQL**: Database for storing application data
- **JDBC**: Java Database Connectivity for connecting Java application with MySQL
- **IntelliJ IDEA**: Integrated Development Environment (IDE)
- **Git**: Version control

## Project Structure

```plaintext
HMS/
├── .idea/                      # IntelliJ IDEA configuration files
├── out/                        # Compiled class files
├── src/                        # Source code directory
│   └── hospital.management.system/
│       ├── All_Patient_info.java
│       ├── Ambulance.java
│       ├── conn.java
│       ├── Department.java
│       ├── Employee_info.java
│       ├── Login.java
│       ├── NEW_PATIENT.java
│       ├── Patient_discharge.java
│       ├── Reception.java
│       ├── Room.java
│       ├── SearchRoom.java
│       └── update_patient_details.java
├── HMS.sql                       # SQL scripts
├── icon/                       # Icons used in the application
├── .gitignore
├── HMS.iml
└── README.md                   # Project documentation (this file)
```

## Database Setup

1. **Open MySQL Workbench or any other MySQL client.**

2. **Create a database** named `hospital_management_system`:

   ```sql
   CREATE DATABASE hospital_management_system;
  
3. **Run the SQL scripts provided to create the necessary tables and insert initial data:**

   - Locate the `HMS.sql` file in the root directory of the project.
   - In MySQL Workbench, open a new SQL tab.
   - Use the following command to run the script:

     ```sql
     source path_to_your_project/HMS.sql;
     ```

   - Replace `path_to_your_project` with the actual path to your `HMS.sql` file.

## Installation and Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/khushikalra08/Hospital_Management_System.git

2. **Open the project in IntelliJ IDEA.**

3. **Configure the MySQL database:**

    - Modify the `conn.java` file to include your MySQL username, password, and database name.

4. **Run the project:**

    - Navigate to the `Login.java` file.
    - Right-click and select `Run 'Login.main()'`.

## Usage

1. **Launch the application** to open the login window.
2. **Use the credentials** to log in and access the main interface.
3. **Navigate** through different sections using the buttons provided.

## Contributing

1. **Fork the repository** to your GitHub account.
2. **Create a new branch** for your feature or bug fix:
   ```bash
   git checkout -b feature-branch
3. **Make your changes** and commit them with a descriptive message:

   ```bash
   git commit -am 'Add new feature'
4. **Push your changes** to the new branch:

   ```bash
   git push origin feature-branch

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.


---
