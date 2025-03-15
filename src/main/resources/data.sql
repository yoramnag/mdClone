-- Insert Managers
INSERT INTO manager (id, first_name, last_name) VALUES (10001, 'John', 'Doe');
INSERT INTO manager (id, first_name, last_name) VALUES (10002, 'Jane', 'Smith');

-- Insert Employees
INSERT INTO employee (id, first_name, last_name, role, manager_id) VALUES (20001, 'Alice', 'Johnson', 'Developer', 10001);
INSERT INTO employee (id, first_name, last_name, role, manager_id) VALUES (20002, 'Bob', 'Brown', 'Tester',10001);
INSERT INTO employee (id, first_name, last_name, role, manager_id) VALUES (20003, 'Charlie', 'Davis', 'Designer', 10002);
INSERT INTO employee (id, first_name, last_name, role, manager_id) VALUES (20004, 'David', 'Wilson', 'Analyst', 10002);


-- Insert Timesheets
INSERT INTO Timesheet (id, date, start_Date, end_Date, employee_id) VALUES (30001, '2025-03-01', '2025-03-01 09:00:00', '2025-03-01 17:00:00', 20001);
INSERT INTO Timesheet (id, date, start_Date, end_Date, employee_id) VALUES (30002, '2025-03-02', '2025-03-02 09:00:00', '2025-03-02 17:00:00', 20001);
INSERT INTO Timesheet (id, date, start_Date, end_Date, employee_id) VALUES (30003, '2025-03-01', '2025-03-01 10:00:00', '2025-03-01 18:00:00', 20002);
INSERT INTO Timesheet (id, date, start_Date, end_Date, employee_id) VALUES (30004, '2025-03-02', '2025-03-02 10:00:00', '2025-03-02 18:00:00', 20002);
INSERT INTO Timesheet (id, date, start_Date, end_Date, employee_id) VALUES (30005, '2025-03-01', '2025-03-01 08:30:00', '2025-03-01 16:30:00', 20003);
INSERT INTO Timesheet (id, date, start_Date, end_Date, employee_id) VALUES (30006, '2025-03-02', '2025-03-02 08:30:00', '2025-03-02 16:30:00', 20003);
INSERT INTO Timesheet (id, date, start_Date, end_Date, employee_id) VALUES (30007, '2025-03-01', '2025-03-01 09:15:00', '2025-03-01 17:15:00', 20004);
INSERT INTO Timesheet (id, date, start_Date, end_Date, employee_id) VALUES (30008, '2025-03-02', '2025-03-02 09:15:00', '2025-03-02 17:15:00', 20004);
