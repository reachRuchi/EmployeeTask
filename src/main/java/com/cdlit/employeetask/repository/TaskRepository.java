package com.cdlit.employeetask.repository;

import com.cdlit.employeetask.model.Task;
import org.springframework.data.jpa.repository.*;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
