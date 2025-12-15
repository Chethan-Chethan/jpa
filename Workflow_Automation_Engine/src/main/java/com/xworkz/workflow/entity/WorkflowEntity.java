package com.xworkz.workflow.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString

@Table(name = "workflow")
public class WorkflowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "workflow_name")
    private String workflowName;

    @Column(name = "trigger_type")
    private String triggerType;

    @Column(name = "action_type")
    private String actionType;
}
