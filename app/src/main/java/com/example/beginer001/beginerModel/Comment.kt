package com.example.beginer001.beginerModel

import com.orm.SugarRecord
import com.orm.dsl.Table

@Table(name = "t_comment")
class Comment(comment: String): SugarRecord() {

}