package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(value = "case_detail2")
@Data
@NoArgsConstructor
public class CaseDetail2 {
	
	@PrimaryKeyClass
	@Data
	@AllArgsConstructor
	public class Key implements Serializable {
		@PrimaryKeyColumn(name = "case_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private String caseId;
		@PrimaryKeyColumn(name = "update_date", ordinal = 1, type = PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
		private LocalDateTime updateDate;
	}
	
	@PrimaryKey
	private Key key;
	
	@Column(value="active")
	private int active;
	
	@Column(value="uuid")
	private UUID uuid;
	
	@Column(value="platform")
	private String platform;
	
	@Column(value="gsp")
	private String gsp;
	
	@Column(value="client")
	private String client;
	
	@Column(value="system")
	private String system;
	
	@Column(value="prin")
	private String prin;
	
	@Column(value="agent")
	private String agent;
	
	@Column(value="customer")
	private String customer;
	
	@Column(value="type")
	private String type;
	
	@Column(value="type_category")
	private String typeCategory;
	
	@Column(value="resaon")
	private String reason;
	
	@Column(value="status")
	private int status;
	
	@Column(value="priority")
	private int priority;
	
	@Column(value="review_date")
	private LocalDateTime reviewDate;
	
	@Column(value="open_date")
	private LocalDateTime openDate;
	
	@Column(value="close_date")
	private LocalDateTime closeDate;
	
	@Column(value="agency")
	private String agency;
	
	@Column(value="agency_placed_date")
	private LocalDateTime agencyPlacedDate;
	
	@Column(value="agency_previous")
	private String agencyPrevious;
	
	@Column(value="user_assigned")
	private String userAssigned;
	
	@Column(value="user_asssigned_date")
	private LocalDateTime userAssignedDate;
	
	@Column(value="group_assigned")
	private String groupAssigned;
	
	@Column(value="group_asssigned_date")
	private LocalDateTime groupAssignedDate;
	
	@Column(value="queue_assigned")
	private String queueAssigned;
	
	@Column(value="queue_asssigned_date")
	private LocalDateTime queueAssignedDate;
	
	@Column(value="manager_code")
	private String managerCode;
	
	@Column(value="created_by")
	private String createdBy;
	
	@Column(value="updated_by")
	private String updatedBy;
	
	@Column(value="indentifier1")
	private String identifier1;
	
	@Column(value="indentifier2")
	private String identifier2;
	
	@Column(value="indentifier3")
	private String identifier3;
	
	@Column(value="indentifier4")
	private String identifier4;
	
	@Column(value="identifier_date")
	private LocalDateTime identifierDate;
	
	@Column(value="issue_summary_description")
	private String issueSummaryDescription;
	
	@Column(value="issue_resolution_description")
	private String issueResolutionDescription;
	
	@Column(value = "case_value_claimed")
	private double caseValueClaimed;
	
	@Column(value = "case_value_assessed")
	private double caseValueAssessed;
	
	@Column(value = "task_id_list")
	private List<String> taskIdList;
	
	@Column(value="from_case_id")
	private String fromCaseId;
	
	@Column(value="assessed_score1")
	private String assessedScore1;
	
	@Column(value="assessed_score2")
	private String assessedScore2;
	
	@Column(value="assessed_score3")
	private String assessedScore3;
	
	@Column(value="assessed_score4")
	private String assessedScore4;
	
	@Column(value="assessed_score5")
	private String assessedScore5;
	
	@Column(value="task_id_recommended")
	private String taskIdRecommended;
	
	@Column(value="approval_status")
	private String approvalStatus;
	
	@Column(value="approval_action_date")
	private LocalDateTime approvalActionDate;
	
	@Column(value="approval_action_by_user")
	private String approvalActionByUser;
	
}
