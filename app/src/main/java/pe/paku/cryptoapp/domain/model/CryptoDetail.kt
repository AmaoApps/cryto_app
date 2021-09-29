package pe.paku.cryptoapp.domain.model

import pe.paku.cryptoapp.data.remote.dto.TeamMember

data class CryptoDetail(
    val coindId: String,
    val name: String,
    val description: String,
    val isNew: Boolean,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
