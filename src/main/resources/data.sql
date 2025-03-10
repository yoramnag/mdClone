-- Insert Managers
INSERT INTO manager (id, name, last_name) VALUES (1, 'John', 'Doe');
INSERT INTO manager (id, name, last_name) VALUES (2, 'Jane', 'Smith');

-- Insert Employees
INSERT INTO employee (id, name, last_name, manager_id) VALUES (1, 'Alice', 'Johnson', 1);
INSERT INTO employee (id, name, last_name, manager_id) VALUES (2, 'Bob', 'Brown', 1);
INSERT INTO employee (id, name, last_name, manager_id) VALUES (3, 'Charlie', 'Davis', 2);
INSERT INTO employee (id, name, last_name, manager_id) VALUES (4, 'David', 'Wilson', 2);

-- Insert Timesheets
INSERT INTO timesheet (id, date, start_date, end_date, employee_id) VALUES (1, '2025-03-01', '2025-03-01', '2025-03-01', 1);
INSERT INTO timesheet (id, date, start_date, end_date, employee_id) VALUES (2, '2025-03-02', '2025-03-02', '2025-03-02', 1);
INSERT INTO timesheet (id, date, start_date, end_date, employee_id) VALUES (3, '2025-03-01', '2025-03-01', '2025-03-01', 2);
INSERT INTO timesheet (id, date, start_date, end_date, employee_id) VALUES (4, '2025-03-02', '2025-03-02', '2025-03-02', 2);
INSERT INTO timesheet (id, date, start_date, end_date, employee_id) VALUES (5, '2025-03-01', '2025-03-01', '2025-03-01', 3);
INSERT INTO timesheet (id, date, start_date, end_date, employee_id) VALUES (6, '2025-03-02', '2025-03-02', '2025-03-02', 3);
INSERT INTO timesheet (id, date, start_date, end_date, employee_id) VALUES (7, '2025-03-01', '2025-03-01', '2025-03-01', 4);
INSERT INTO timesheet (id, date, start_date, end_date, employee_id) VALUES (8, '2025-03-02', '2025-03-02', '2025-03-02', 4);
